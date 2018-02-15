/**
 * Copyright @ 2012 Quan Nguyen
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package net.sourceforge.vietocr;

import net.sourceforge.vietocr.util.FormLocalizer;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import net.sourceforge.vietpad.components.SimpleFilter;

public class OptionsDialog extends javax.swing.JDialog {

    private int actionSelected = -1;
    private String watchFolder;
    private String outputFolder;
    private String tessPath;
    private String dangAmbigsPath;
    private String curLangCode;
    private boolean watchEnabled;
    private boolean tessLibEnabled;
    private boolean dangAmbigsOn;
    private boolean replaceHyphensEnabled;
    private boolean removeHyphensEnabled;
    private boolean watchDeskewEnabled;
    protected ResourceBundle bundle;

    /**
     * Creates new form OptionsDialog
     */
    public OptionsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        if (Gui.WINDOWS) {
//            jTabbedPane1.remove(jPanelTessPath);
            this.jButtonTess.setEnabled(false);
        }

        bundle = ResourceBundle.getBundle("net/sourceforge/vietocr/OptionsDialog");

        this.setLocationRelativeTo(parent);
        getRootPane().setDefaultButton(jButtonOK);

        //  Handle escape key to hide the dialog
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelCommand = new javax.swing.JPanel();
        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelTessPath = new javax.swing.JPanel();
        jLabelTess = new javax.swing.JLabel();
        jTextFieldTess = new javax.swing.JTextField();
        jButtonTess = new javax.swing.JButton();
        jCheckBoxTessLib = new javax.swing.JCheckBox();
        jPanelDangAmbigsPath = new javax.swing.JPanel();
        jLabelDangAmbigs = new javax.swing.JLabel();
        jButtonDangAmbigs = new javax.swing.JButton();
        jTextFieldDangAmbigs = new javax.swing.JTextField();
        jCheckBoxDangAmbigs = new javax.swing.JCheckBox();
        jPanelWatchFolder = new javax.swing.JPanel();
        jLabelWatch = new javax.swing.JLabel();
        jTextFieldWatch = new javax.swing.JTextField();
        jLabelOutput = new javax.swing.JLabel();
        jTextFieldOutput = new javax.swing.JTextField();
        jLabelOutputFormat = new javax.swing.JLabel();
        jPanelWatch = new javax.swing.JPanel();
        jComboBoxOutputFormat = new javax.swing.JComboBox();
        jCheckBoxWatch = new javax.swing.JCheckBox();
        jCheckBoxWatchDeskew = new javax.swing.JCheckBox();
        jButtonWatch = new javax.swing.JButton();
        jButtonOutput = new javax.swing.JButton();
        jPanelHyphens = new javax.swing.JPanel();
        jCheckBoxReplaceHyphens = new javax.swing.JCheckBox();
        jCheckBoxRemoveHyphens = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("net/sourceforge/vietocr/OptionsDialog"); // NOI18N
        setTitle(bundle.getString("this.Title")); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        jPanelCommand.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 0, 6, 4));
        jPanelCommand.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButtonOK.setText(bundle.getString("jButtonOK.Text")); // NOI18N
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });
        jPanelCommand.add(jButtonOK);

        jButtonCancel.setText(bundle.getString("jButtonCancel.Text")); // NOI18N
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanelCommand.add(jButtonCancel);

        getContentPane().add(jPanelCommand, java.awt.BorderLayout.SOUTH);

        jPanelTessPath.setLayout(new java.awt.GridBagLayout());

        jLabelTess.setLabelFor(jTextFieldTess);
        jLabelTess.setText(bundle.getString("jLabelTess.Text")); // NOI18N
        jPanelTessPath.add(jLabelTess, new java.awt.GridBagConstraints());

        jTextFieldTess.setEditable(false);
        jTextFieldTess.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanelTessPath.add(jTextFieldTess, gridBagConstraints);

        jButtonTess.setText("...");
        jButtonTess.setToolTipText(bundle.getString("jButtonTess.ToolTipText")); // NOI18N
        jButtonTess.setPreferredSize(new java.awt.Dimension(30, 23));
        jButtonTess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTessActionPerformed(evt);
            }
        });
        jPanelTessPath.add(jButtonTess, new java.awt.GridBagConstraints());

        jCheckBoxTessLib.setText(bundle.getString("jCheckBoxTessLib.Text")); // NOI18N
        jCheckBoxTessLib.setActionCommand("libtesseract302");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanelTessPath.add(jCheckBoxTessLib, gridBagConstraints);
        jCheckBoxTessLib.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab("Tesseract", jPanelTessPath);

        jPanelDangAmbigsPath.setLayout(new java.awt.GridBagLayout());

        jLabelDangAmbigs.setLabelFor(jTextFieldDangAmbigs);
        jLabelDangAmbigs.setText(bundle.getString("jLabelDangAmbigs.Text")); // NOI18N
        jPanelDangAmbigsPath.add(jLabelDangAmbigs, new java.awt.GridBagConstraints());

        jButtonDangAmbigs.setText("...");
        jButtonDangAmbigs.setToolTipText(bundle.getString("jButtonDangAmbigs.ToolTipText")); // NOI18N
        jButtonDangAmbigs.setPreferredSize(new java.awt.Dimension(30, 23));
        jButtonDangAmbigs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDangAmbigsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanelDangAmbigsPath.add(jButtonDangAmbigs, gridBagConstraints);

        jTextFieldDangAmbigs.setEditable(false);
        jTextFieldDangAmbigs.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanelDangAmbigsPath.add(jTextFieldDangAmbigs, gridBagConstraints);

        jCheckBoxDangAmbigs.setText(bundle.getString("jCheckBoxDangAmbigs.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanelDangAmbigsPath.add(jCheckBoxDangAmbigs, gridBagConstraints);

        jTabbedPane1.addTab("DangAmbigs.txt", jPanelDangAmbigsPath);

        jPanelWatchFolder.setLayout(new java.awt.GridBagLayout());

        jLabelWatch.setLabelFor(jTextFieldWatch);
        jLabelWatch.setText(bundle.getString("jLabelWatch.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelWatchFolder.add(jLabelWatch, gridBagConstraints);

        jTextFieldWatch.setEditable(false);
        jTextFieldWatch.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanelWatchFolder.add(jTextFieldWatch, gridBagConstraints);

        jLabelOutput.setLabelFor(jTextFieldOutput);
        jLabelOutput.setText(bundle.getString("jLabelOutput.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelWatchFolder.add(jLabelOutput, gridBagConstraints);

        jTextFieldOutput.setEditable(false);
        jTextFieldOutput.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanelWatchFolder.add(jTextFieldOutput, gridBagConstraints);

        jLabelOutputFormat.setLabelFor(jComboBoxOutputFormat);
        jLabelOutputFormat.setText(bundle.getString("jComboBoxOutputFormat.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanelWatchFolder.add(jLabelOutputFormat, gridBagConstraints);

        jComboBoxOutputFormat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "text", "text+", "hocr", "pdf" }));
        jComboBoxOutputFormat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxOutputFormatMouseEntered(evt);
            }
        });
        jPanelWatch.add(jComboBoxOutputFormat);

        jCheckBoxWatch.setText(bundle.getString("jCheckBoxWatch.Text")); // NOI18N
        jPanelWatch.add(jCheckBoxWatch);

        jCheckBoxWatchDeskew.setText(bundle.getString("jCheckBoxWatchDeskew.Text")); // NOI18N
        jPanelWatch.add(jCheckBoxWatchDeskew);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        jPanelWatchFolder.add(jPanelWatch, gridBagConstraints);

        jButtonWatch.setText("...");
        jButtonWatch.setToolTipText(bundle.getString("jButtonWatch.ToolTipText")); // NOI18N
        jButtonWatch.setPreferredSize(new java.awt.Dimension(30, 23));
        jButtonWatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWatchActionPerformed(evt);
            }
        });
        jPanelWatchFolder.add(jButtonWatch, new java.awt.GridBagConstraints());

        jButtonOutput.setText("...");
        jButtonOutput.setToolTipText(bundle.getString("jButtonOutput.ToolTipText")); // NOI18N
        jButtonOutput.setPreferredSize(new java.awt.Dimension(30, 23));
        jButtonOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOutputActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanelWatchFolder.add(jButtonOutput, gridBagConstraints);

        jTabbedPane1.addTab(bundle.getString("Watch"), jPanelWatchFolder); // NOI18N

        jPanelHyphens.setLayout(new java.awt.GridBagLayout());

        jCheckBoxReplaceHyphens.setText(bundle.getString("jCheckBoxReplaceHyphens.Text")); // NOI18N
        jCheckBoxReplaceHyphens.setToolTipText(bundle.getString("jCheckBoxReplaceHyphens.ToolTipText")); // NOI18N
        jCheckBoxReplaceHyphens.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBoxReplaceHyphens.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelHyphens.add(jCheckBoxReplaceHyphens, gridBagConstraints);
        jCheckBoxReplaceHyphens.getAccessibleContext().setAccessibleName("ReplaceHyphens");

        jCheckBoxRemoveHyphens.setText(bundle.getString("jCheckBoxRemoveHyphens.Text")); // NOI18N
        jCheckBoxRemoveHyphens.setToolTipText(bundle.getString("jCheckBoxRemoveHyphens.ToolTipText")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelHyphens.add(jCheckBoxRemoveHyphens, gridBagConstraints);

        jTabbedPane1.addTab("Hyphens", jPanelHyphens);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        jTabbedPane1.getAccessibleContext().setAccessibleName("Watch");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonWatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWatchActionPerformed
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        filechooser.setAcceptAllFileFilterUsed(false);
        filechooser.setApproveButtonText(bundle.getString("Set"));
        filechooser.setCurrentDirectory(new File(watchFolder));
        filechooser.setDialogTitle(bundle.getString("Set_Watch_Folder"));
        if (filechooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            watchFolder = filechooser.getSelectedFile().getPath();
            this.jTextFieldWatch.setText(watchFolder);
        }
    }//GEN-LAST:event_jButtonWatchActionPerformed

    private void jButtonOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOutputActionPerformed
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        filechooser.setAcceptAllFileFilterUsed(false);
        filechooser.setApproveButtonText(bundle.getString("Set"));
        filechooser.setCurrentDirectory(new File(outputFolder));
        filechooser.setDialogTitle(bundle.getString("Set_Output_Folder"));
        if (filechooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            outputFolder = filechooser.getSelectedFile().getPath();
            this.jTextFieldOutput.setText(outputFolder);
        }
    }//GEN-LAST:event_jButtonOutputActionPerformed

    private void jButtonTessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTessActionPerformed
        JFileChooser pathchooser = new JFileChooser(tessPath);
        pathchooser.setAcceptAllFileFilterUsed(false);
        pathchooser.setApproveButtonText(bundle.getString("Set"));
        pathchooser.setDialogTitle(bundle.getString("Locate_Tesseract"));
        int returnVal = pathchooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String path = pathchooser.getCurrentDirectory().getPath();
            if (!tessPath.equals(path)) {
                setTessPath(path);
            }
        }
    }//GEN-LAST:event_jButtonTessActionPerformed

    private void jButtonDangAmbigsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDangAmbigsActionPerformed
        JFileChooser pathchooser = new JFileChooser(dangAmbigsPath);
        FileFilter txtFilter = new SimpleFilter("txt", "Text");
        pathchooser.addChoosableFileFilter(txtFilter);
        pathchooser.setAcceptAllFileFilterUsed(false);
        pathchooser.setApproveButtonText(bundle.getString("Set"));
        pathchooser.setDialogTitle(bundle.getString("Path_to") + " " + curLangCode + ".DangAmbigs.txt");
        int returnVal = pathchooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String path = pathchooser.getCurrentDirectory().getPath();
            if (!dangAmbigsPath.equals(path)) {
                setDangAmbigsPath(path);
            }
        }
    }//GEN-LAST:event_jButtonDangAmbigsActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        actionSelected = JOptionPane.OK_OPTION;
        this.setVisible(false);
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        actionSelected = JOptionPane.CANCEL_OPTION;
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.jTextFieldWatch.setText(watchFolder);
        this.jTextFieldOutput.setText(outputFolder);
        this.jCheckBoxWatch.setSelected(watchEnabled);
        this.jTextFieldTess.setText(tessPath);
        this.jTextFieldDangAmbigs.setText(dangAmbigsPath);
        this.jCheckBoxDangAmbigs.setSelected(dangAmbigsOn);
        this.jCheckBoxTessLib.setSelected(tessLibEnabled);
        this.jCheckBoxReplaceHyphens.setSelected(replaceHyphensEnabled);
        this.jCheckBoxRemoveHyphens.setSelected(removeHyphensEnabled);
        this.jCheckBoxWatchDeskew.setSelected(watchDeskewEnabled);
    }//GEN-LAST:event_formWindowActivated

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        watchFolder = this.jTextFieldWatch.getText();
        outputFolder = this.jTextFieldOutput.getText();
        watchEnabled = this.jCheckBoxWatch.isSelected();
        tessPath = this.jTextFieldTess.getText();
        dangAmbigsPath = this.jTextFieldDangAmbigs.getText();
        dangAmbigsOn = this.jCheckBoxDangAmbigs.isSelected();
        replaceHyphensEnabled = this.jCheckBoxReplaceHyphens.isSelected();
        removeHyphensEnabled = this.jCheckBoxRemoveHyphens.isSelected();
        watchDeskewEnabled = this.jCheckBoxWatchDeskew.isSelected();
    }//GEN-LAST:event_formWindowDeactivated

    private void jComboBoxOutputFormatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxOutputFormatMouseEntered
        String val = this.jComboBoxOutputFormat.getSelectedItem().toString();
        if ("text+".equals(val)) {
            val = "Text with postprocessing";
        } else if ("text".equals(val)) {
            val = "Text with no postprocessing";
        } else if ("pdf".equals(val)) {
            val = "PDF";
        } else if ("hocr".equals(val)) {
            val = "hOCR";
        } else {
            val = null;
        }
        this.jComboBoxOutputFormat.setToolTipText(val);
    }//GEN-LAST:event_jComboBoxOutputFormatMouseEntered

    public int showDialog() {
        setVisible(true);
        return actionSelected;
    }

    void changeUILanguage(final Locale locale) {
        Locale.setDefault(locale);
        bundle = ResourceBundle.getBundle("net/sourceforge/vietocr/OptionsDialog");

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                FormLocalizer localizer = new FormLocalizer(OptionsDialog.this, OptionsDialog.class);
                localizer.ApplyCulture(bundle);
                jTabbedPane1.setTitleAt(0, bundle.getString("Watch"));
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                OptionsDialog dialog = new OptionsDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDangAmbigs;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonOutput;
    private javax.swing.JButton jButtonTess;
    private javax.swing.JButton jButtonWatch;
    private javax.swing.JCheckBox jCheckBoxDangAmbigs;
    private javax.swing.JCheckBox jCheckBoxRemoveHyphens;
    private javax.swing.JCheckBox jCheckBoxReplaceHyphens;
    private javax.swing.JCheckBox jCheckBoxTessLib;
    private javax.swing.JCheckBox jCheckBoxWatch;
    private javax.swing.JCheckBox jCheckBoxWatchDeskew;
    private javax.swing.JComboBox jComboBoxOutputFormat;
    private javax.swing.JLabel jLabelDangAmbigs;
    private javax.swing.JLabel jLabelOutput;
    private javax.swing.JLabel jLabelOutputFormat;
    private javax.swing.JLabel jLabelTess;
    private javax.swing.JLabel jLabelWatch;
    private javax.swing.JPanel jPanelCommand;
    private javax.swing.JPanel jPanelDangAmbigsPath;
    private javax.swing.JPanel jPanelHyphens;
    private javax.swing.JPanel jPanelTessPath;
    private javax.swing.JPanel jPanelWatch;
    private javax.swing.JPanel jPanelWatchFolder;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldDangAmbigs;
    private javax.swing.JTextField jTextFieldOutput;
    private javax.swing.JTextField jTextFieldTess;
    private javax.swing.JTextField jTextFieldWatch;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the watchFolder
     */
    public String getWatchFolder() {
        return watchFolder;
    }

    /**
     * @param watchFolder the watchFolder to set
     */
    public void setWatchFolder(String watchFolder) {
        this.watchFolder = watchFolder;
    }

    /**
     * @return the outputFolder
     */
    public String getOutputFolder() {
        return outputFolder;
    }

    /**
     * @param outputFolder the outputFolder to set
     */
    public void setOutputFolder(String outputFolder) {
        this.outputFolder = outputFolder;
    }

    /**
     * @return the watchEnabled
     */
    public boolean isWatchEnabled() {
        watchEnabled = jCheckBoxWatch.isSelected();
        return watchEnabled;
    }

    /**
     * @param watchEnabled the watchEnabled to set
     */
    public void setWatchEnabled(boolean watchEnabled) {
        this.watchEnabled = watchEnabled;
    }

    /**
     * @return the tessPath
     */
    public String getTessPath() {
        return tessPath;
    }

    /**
     * @param tessPath the tessPath to set
     */
    public void setTessPath(String tessPath) {
        this.tessPath = tessPath;
    }

    /**
     * @return the dangAmbigsPath
     */
    public String getDangAmbigsPath() {
        return dangAmbigsPath;
    }

    /**
     * @param dangAmbigsPath the dangAmbigsPath to set
     */
    public void setDangAmbigsPath(String dangAmbigsPath) {
        this.dangAmbigsPath = dangAmbigsPath;
    }

    /**
     * @param curLangCode the curLangCode to set
     */
    public void setCurLangCode(String curLangCode) {
        this.curLangCode = curLangCode;
    }

    /**
     * @return the dangAmbigsOn
     */
    public boolean isDangAmbigsEnabled() {
        dangAmbigsOn = this.jCheckBoxDangAmbigs.isSelected();
        return dangAmbigsOn;
    }

    /**
     * @param dangAmbigsOn the dangAmbigsOn to set
     */
    public void setDangAmbigsEnabled(boolean dangAmbigsOn) {
        this.dangAmbigsOn = dangAmbigsOn;
    }

    /**
     * @return the tessLibEnabled
     */
    public boolean isTessLibEnabled() {
        tessLibEnabled = this.jCheckBoxTessLib.isSelected();
        return tessLibEnabled;
    }

    /**
     * @param tessLibEnabled the tessLibEnabled to set
     */
    public void setTessLibEnabled(boolean tessLibEnabled) {
        this.tessLibEnabled = tessLibEnabled;
    }

    /**
     * @return the selectedFormat
     */
    public String getSelectedOutputFormat() {
        return this.jComboBoxOutputFormat.getSelectedItem().toString();
    }

    /**
     * @param selectedFormat the selectedFormat to set
     */
    public void setSelectedOutputFormat(String selectedFormat) {
        this.jComboBoxOutputFormat.setSelectedItem(selectedFormat);
    }

    /**
     * @return
     */
    public boolean isReplaceHyphensEnabled() {
        replaceHyphensEnabled = this.jCheckBoxReplaceHyphens.isSelected();
        return replaceHyphensEnabled;
    }

    /**
     * @param replaceHyphensEnabled
     */
    public void setReplaceHyphensEnabled(boolean replaceHyphensEnabled) {
        this.replaceHyphensEnabled = replaceHyphensEnabled;
    }

    /**
     * @return
     */
    public boolean isRemoveHyphensEnabled() {
        removeHyphensEnabled = this.jCheckBoxRemoveHyphens.isSelected();
        return removeHyphensEnabled;
    }

    /**
     * @param removeHyphensEnabled
     */
    public void setRemoveHyphensEnabled(boolean removeHyphensEnabled) {
        this.removeHyphensEnabled = removeHyphensEnabled;
    }

    /**
     * @return the watchDeskewEnabled
     */
    public boolean isWatchDeskewEnabled() {
        return watchDeskewEnabled;
    }

    /**
     * @param watchDeskewEnabled the watchDeskewEnabled to set
     */
    public void setWatchDeskewEnabled(boolean watchDeskewEnabled) {
        this.watchDeskewEnabled = watchDeskewEnabled;
    }
}
