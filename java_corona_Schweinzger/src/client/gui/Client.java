package client.gui;

import client.ConnectionWorker;
import com.google.gson.Gson;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import server.Request;
import server.Response;


public class Client extends javax.swing.JFrame {
    private MyConnectionWorker worker;
    
    private boolean tryToStart;
    private boolean tryToStop;
    private boolean tryToClear;
    private boolean tryToEnd;

    public Client() {
        initComponents();
        setTitle("Stoppuhr");
        setMinimumSize(new Dimension(300, 350));
        setLocationRelativeTo(null);
        

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanEast = new javax.swing.JPanel();
        jPanBtns = new javax.swing.JPanel();
        jBtnConnect = new javax.swing.JButton();
        jBtnDisconnect = new javax.swing.JButton();
        jBtnStart = new javax.swing.JButton();
        jBtnStop = new javax.swing.JButton();
        jBtnClear = new javax.swing.JButton();
        jBtnEnd = new javax.swing.JButton();
        jPanNorth = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSliderRefresh = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jPanCenter = new javax.swing.JPanel();
        jLabTime = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanBtns.setLayout(new java.awt.GridBagLayout());

        jBtnConnect.setText("Connect");
        jBtnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConnectActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanBtns.add(jBtnConnect, gridBagConstraints);

        jBtnDisconnect.setText("Disconnect");
        jBtnDisconnect.setEnabled(false);
        jBtnDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDisconnectActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanBtns.add(jBtnDisconnect, gridBagConstraints);

        jBtnStart.setText("Start");
        jBtnStart.setEnabled(false);
        jBtnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStartActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanBtns.add(jBtnStart, gridBagConstraints);

        jBtnStop.setText("Stop");
        jBtnStop.setEnabled(false);
        jBtnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStopActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanBtns.add(jBtnStop, gridBagConstraints);

        jBtnClear.setText("Clear");
        jBtnClear.setEnabled(false);
        jBtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanBtns.add(jBtnClear, gridBagConstraints);

        jBtnEnd.setText("End");
        jBtnEnd.setEnabled(false);
        jBtnEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEndActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanBtns.add(jBtnEnd, gridBagConstraints);

        jPanEast.add(jPanBtns);

        getContentPane().add(jPanEast, java.awt.BorderLayout.LINE_END);

        jPanNorth.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanNorth.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Refreshrate: 1s");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        jPanNorth.add(jLabel1, gridBagConstraints);

        jSliderRefresh.setMaximum(999);
        jSliderRefresh.setValue(0);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        jPanNorth.add(jSliderRefresh, gridBagConstraints);

        jLabel2.setText("1ms");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        jPanNorth.add(jLabel2, gridBagConstraints);

        getContentPane().add(jPanNorth, java.awt.BorderLayout.NORTH);

        jPanCenter.setLayout(new java.awt.GridLayout(1, 0));

        jLabTime.setAlignment(java.awt.Label.CENTER);
        jLabTime.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabTime.setText("0.000");
        jPanCenter.add(jLabTime);

        getContentPane().add(jPanCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConnectActionPerformed
        try {
            worker = new MyConnectionWorker("127.0.0.1", 8080);
            worker.execute();
            jBtnConnect.setEnabled(false);
            jBtnDisconnect.setEnabled(true);
            jBtnEnd.setEnabled(true);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, "Konnte nicht mit dem Server verbinden", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnConnectActionPerformed

    private void jBtnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDisconnectActionPerformed
        worker.cancel(true);
        jBtnConnect.setEnabled(true);
        jBtnDisconnect.setEnabled(false);
        jBtnStart.setEnabled(false);
        jBtnStop.setEnabled(false);
        jBtnClear.setEnabled(false);
        jBtnEnd.setEnabled(false);
    }//GEN-LAST:event_jBtnDisconnectActionPerformed

    private void jBtnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnStartActionPerformed
        tryToStart = true;
    }//GEN-LAST:event_jBtnStartActionPerformed

    private void jBtnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnStopActionPerformed
        tryToStop = true;
    }//GEN-LAST:event_jBtnStopActionPerformed

    private void jBtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClearActionPerformed
        tryToClear = true;
    }//GEN-LAST:event_jBtnClearActionPerformed

    private void jBtnEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEndActionPerformed
        tryToEnd = true;
    }//GEN-LAST:event_jBtnEndActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnClear;
    private javax.swing.JButton jBtnConnect;
    private javax.swing.JButton jBtnDisconnect;
    private javax.swing.JButton jBtnEnd;
    private javax.swing.JButton jBtnStart;
    private javax.swing.JButton jBtnStop;
    private java.awt.Label jLabTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanBtns;
    private javax.swing.JPanel jPanCenter;
    private javax.swing.JPanel jPanEast;
    private javax.swing.JPanel jPanNorth;
    private javax.swing.JSlider jSliderRefresh;
    // End of variables declaration//GEN-END:variables


    
    private class MyConnectionWorker extends ConnectionWorker { 
        private Socket socket;

        public MyConnectionWorker(String host, int port) throws IOException {
            super(host, port);
        }

        @Override
        protected void process(List<Response> list) {
            for(Response r : list) {
                if(r.isMaster()) {
                    jBtnConnect.setEnabled(false);
                    jBtnDisconnect.setEnabled(true);
                    jBtnStart.setEnabled(true);
                    jBtnStop.setEnabled(true);
                    jBtnClear.setEnabled(true);
                    jBtnEnd.setEnabled(true);
                } else {
                    jBtnConnect.setEnabled(false);
                    jBtnDisconnect.setEnabled(true);
                    jBtnStart.setEnabled(false);
                    jBtnStop.setEnabled(false);
                    jBtnClear.setEnabled(false);
                    jBtnEnd.setEnabled(false);
                }

                if(r.isRunning()) {
                    jBtnStart.setEnabled(false);
                    jBtnStop.setEnabled(true);
                    jBtnClear.setEnabled(true);
                } else {
                    jBtnStart.setEnabled(true);
                    jBtnStop.setEnabled(false);
                    jBtnClear.setEnabled(false);                    
                }
                
                jLabTime.setText(String.format("%.3f", r.getTime()));
            }
        }

        @Override
        protected void done() {
            try {
                get();
            } catch(Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(Client.this, "Unbekannter Fehler", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        }   
    }
}
