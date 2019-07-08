package pasa.cbentley.jtronconneuse.swing.run;

import pasa.cbentley.jtronconneuse.common.ILogEntryListener;
import pasa.cbentley.jtronconneuse.common.JSawLogEntry;
import pasa.cbentley.jtronconneuse.server.JTroncoServer;
import pasa.cbentley.jtronconneuse.swing.panels.PanelMain;
import pasa.cbentley.swing.window.CBentleyFrame;

public class RunSwingTroncoTabs extends AbstractTroncoRunner implements ILogEntryListener {

   protected JTroncoServer server;

   public static void main(final String[] args) {
      //create runner
      final RunSwingTroncoTabs runner = new RunSwingTroncoTabs();
      //init prefs files etc.
      runner.initUIThreadOutside();
      //init UI stuff inside AWT thread.
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            runner.initUIThreadInside();
         }
      });
   }

   public void cmdExit() {
      if(server != null) {
         server.stop();
      }
      super.cmdExit();
   }

   protected void initUIThreadInside() {

      //start the server
      
      server = new JTroncoServer(jtc);
      server.setLogEntryListener(this);
      
      frame = new CBentleyFrame(sc);
      frame.setTitle("JTronconneuse Server");
      frame.setPrefID("jtronconneuse_server_tabs");

      PanelMain panelMain = new PanelMain(tsc);
      //initialize it
      panelMain.initCheck();

      sc.guiRegister(panelMain);

      frame.getContentPane().add(panelMain);
      frame.positionFrame();
      frame.setExitable(this);

      sc.guiUpdate();
   }

   public void newLogEntry(JSawLogEntry log) {
      
   }
}
