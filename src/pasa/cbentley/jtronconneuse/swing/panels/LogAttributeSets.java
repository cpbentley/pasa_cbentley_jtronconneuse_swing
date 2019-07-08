package pasa.cbentley.jtronconneuse.swing.panels;

import java.awt.Color;

import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import pasa.cbentley.jtronconneuse.swing.ctx.TroncoSwingCtx;

public class LogAttributeSets {

   protected final TroncoSwingCtx tsc;

   private String                 fontName;

   private StyleContext           styleContext;

   private AttributeSet           setFontDefault;

   private AttributeSet           setTag;

   private Color                  colorTag;

   public LogAttributeSets(TroncoSwingCtx tsc) {
      this(tsc, "Lucida Console");
   }

   public LogAttributeSets(TroncoSwingCtx tsc, String fontName) {
      this.tsc = tsc;
      this.fontName = fontName;

      styleContext = StyleContext.getDefaultStyleContext();

      setFontDefault = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.FontFamily, fontName);
      colorTag = new Color(142, 50, 45);
      setTag = styleContext.addAttribute(setFontDefault, StyleConstants.Foreground, colorTag);
   }

   public AttributeSet getTag() {
      return setTag;
   }
}
