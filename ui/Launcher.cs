using System;
using System.IO;
using System.Management.Automation;
using System.Management.Automation.Runspaces;
using System.Threading;
using System.Windows.Forms;

// Windowed host only. All trading algorithms remain in the Java project.
internal static class Launcher
{
    [STAThread]
    private static void Main()
    {
        try
        {
            string root = AppDomain.CurrentDomain.BaseDirectory;
            string script = Path.Combine(root, "gui.ps1");
            using (Runspace runspace = RunspaceFactory.CreateRunspace())
            {
                runspace.ApartmentState = ApartmentState.STA;
                runspace.ThreadOptions = PSThreadOptions.UseCurrentThread;
                runspace.Open();
                runspace.SessionStateProxy.SetVariable("TradeOptimaRoot", root);
                using (PowerShell shell = PowerShell.Create())
                {
                    shell.Runspace = runspace;
                    shell.AddScript(File.ReadAllText(script));
                    shell.Invoke();
                    if (shell.HadErrors)
                    {
                        string message = "";
                        foreach (ErrorRecord error in shell.Streams.Error) message += error.ToString() + Environment.NewLine;
                        MessageBox.Show(message, "TradeOptima", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }
            }
        }
        catch (Exception ex)
        {
            MessageBox.Show(ex.Message, "TradeOptima could not start", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }
    }
}
