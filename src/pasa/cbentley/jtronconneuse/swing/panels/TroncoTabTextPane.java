package pasa.cbentley.jtronconneuse.swing.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;

import pasa.cbentley.core.src4.logging.Config;
import pasa.cbentley.core.src4.logging.DLogEntry;
import pasa.cbentley.core.src4.logging.DLogEntryOfConfig;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IConfig;
import pasa.cbentley.core.src4.logging.ITechConfig;
import pasa.cbentley.jtronconneuse.common.JSawLogEntry;
import pasa.cbentley.jtronconneuse.swing.ctx.TroncoSwingCtx;
import pasa.cbentley.swing.widgets.b.BButton;
import pasa.cbentley.swing.widgets.b.BCheckBox;

/**
 * Simple tab with just a text pane
 * @author Charles Bentley
 *
 */
public class TroncoTabTextPane extends TroncoTabAbstract implements ActionListener {

   private JTextPane        consoleText;

   private BButton          butClear;

   private BCheckBox        cbOneLine;

   private LogAttributeSets attributes;

   private Config config;
   public TroncoTabTextPane(TroncoSwingCtx tsc, String id) {
      super(tsc, id);

      config = new Config(tsc.getUCtx());
      
      EmptyBorder eb = new EmptyBorder(new Insets(10, 10, 10, 10));
      consoleText = new JTextPane();
      consoleText.setBorder(eb);
      //tPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
      consoleText.setMargin(new Insets(5, 5, 5, 5));
      //jt.setPreferredSize(new Dimension(400, 400));
      JScrollPane jsp = new JScrollPane(consoleText);
      jsp.setPreferredSize(new Dimension(400, 200));

      this.add(jsp, BorderLayout.CENTER);

      PanelTronco buttonPanel = new PanelTronco(tsc);
      buttonPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

      butClear = new BButton(sc, this, "but.clear");
      cbOneLine = new BCheckBox(sc, this, "cb.oneline");

      buttonPanel.add(butClear);
      buttonPanel.add(cbOneLine);

      this.add(buttonPanel, BorderLayout.EAST);

      attributes = new LogAttributeSets(tsc);
      //customize attributes here
   }

   public void actionPerformed(ActionEvent e) {
      Object src = e.getSource();
      if (src == butClear) {
         cmdClear();
      } else if (src == cbOneLine) {
         cmdToggleOneLine();
      }
   }

   private void cmdToggleOneLine() {

   }

   public IConfig getConfig() {
      return config;
   }

   public void newLogArrivedTronconneIt(JSawLogEntry jlog) {
      
      DLogEntry log = null;
      //get our tab config
      IConfig config = getConfig();
      //check if log is accepted
      DLogEntryOfConfig entryConfig = config.getEntryConfig(log);

      if (entryConfig.isAccepted()) {
         //get formatter based on current config ?

         //we are the formatter.

         //first enter message. format is hard coded
         String tagString = jlog.getTagString();
         appendTag(tagString);
         if (entryConfig.hasConfigFlag(ITechConfig.CONFIG_FLAG_04_SHOW_THREAD)) {
            appendThread("[" + jlog.getThreadName() + "]");
         }
         appendTab();
      }
   }

   public void appendTab() {

   }

   public void appendThread(String thread) {

   }

   public void appendTag(String tag) {
      appendToPane(consoleText, tag, attributes.getTag());
   }

   public void appendToPane(JTextPane tp, String msg, AttributeSet aset) {
      int len = tp.getDocument().getLength();
      tp.setCaretPosition(len);
      tp.setCharacterAttributes(aset, false);
      tp.replaceSelection(msg);
   }

   private void cmdClear() {
      consoleText.setText("");
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "TroncoTabTextPane");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "TroncoTabTextPane");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
