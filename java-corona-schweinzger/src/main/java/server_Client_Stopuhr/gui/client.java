/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_Client_Stopuhr.gui;

import com.google.gson.Gson;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.SwingWorker;
import server_Client_Stopuhr.ConnectionWorker;
import server_Client_Stopuhr.Request;
import server_Client_Stopuhr.Response;

public class client extends javax.swing.JFrame {
    
    private boolean start = false;
    private boolean stop = false;
    private boolean clear = false;
    private boolean end = false;
    
    public client() {
        initComponents();
        setTitle("Client");
        setMinimumSize(new Dimension(300, 250));
        setSize(400, 300);
        jTimer.setText("0.000");

        jbConnect.setEnabled(true);
        jbDisconnect.setEnabled(false);
        jbStart.setEnabled(false);
        jbStop.setEnabled(false);
        jbClear.setEnabled(false);
        jbEnd.setEnabled(false);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTimer = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jbConnect = new javax.swing.JButton();
        jbDisconnect = new javax.swing.JButton();
        jbStart = new javax.swing.JButton();
        jbStop = new javax.swing.JButton();
        jbClear = new javax.swing.JButton();
        jbEnd = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jsRefreshrate = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTimer.setAlignment(java.awt.Label.CENTER);
        jTimer.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jTimer.setText("label1");
        getContentPane().add(jTimer, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(6, 0));

        jbConnect.setText("Connect");
        jbConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConnectActionPerformed(evt);
            }
        });
        jPanel2.add(jbConnect);

        jbDisconnect.setText("Disconnect");
        jbDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDisconnectActionPerformed(evt);
            }
        });
        jPanel2.add(jbDisconnect);

        jbStart.setText("Start");
        jbStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStartActionPerformed(evt);
            }
        });
        jPanel2.add(jbStart);

        jbStop.setText("Stop");
        jbStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStopActionPerformed(evt);
            }
        });
        jPanel2.add(jbStop);

        jbClear.setText("Clear");
        jbClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClearActionPerformed(evt);
            }
        });
        jPanel2.add(jbClear);

        jbEnd.setText("End");
        jbEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEndActionPerformed(evt);
            }
        });
        jPanel2.add(jbEnd);

        jPanel1.add(jPanel2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Refreshrate: 1s");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel3.add(jsRefreshrate, gridBagConstraints);

        jLabel2.setText("1ms");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel3.add(jLabel2, gridBagConstraints);

        getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConnectActionPerformed

        System.out.println("pressed" + Thread.currentThread().getId());
        ConnectionWorker worker = new MyConnectionWorker(8080, "127.0.0.1");
        worker.execute();
    }//GEN-LAST:event_jbConnectActionPerformed

    private void jbDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDisconnectActionPerformed
        jbConnect.setEnabled(true);
        jbDisconnect.setEnabled(false);
        jbStart.setEnabled(false);
        jbStop.setEnabled(false);
        jbClear.setEnabled(false);
        jbEnd.setEnabled(false);
    }//GEN-LAST:event_jbDisconnectActionPerformed

    private void jbStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStartActionPerformed
        jbConnect.setEnabled(false);
        jbDisconnect.setEnabled(true);
        jbStart.setEnabled(false);
        jbStop.setEnabled(true);
        jbClear.setEnabled(true);
        jbEnd.setEnabled(true);
        
        start = true;
    }//GEN-LAST:event_jbStartActionPerformed

    private void jbStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStopActionPerformed
        jbConnect.setEnabled(false);
        jbDisconnect.setEnabled(true);
        jbStart.setEnabled(true);
        jbStop.setEnabled(false);
        jbClear.setEnabled(false);
        jbEnd.setEnabled(true);
        
        stop = true;
    }//GEN-LAST:event_jbStopActionPerformed

    private void jbClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClearActionPerformed
        jbConnect.setEnabled(false);
        jbDisconnect.setEnabled(true);
        jbStart.setEnabled(true);
        jbStop.setEnabled(false);
        jbClear.setEnabled(false);
        jbEnd.setEnabled(true);
        jTimer.setText("0.000");
        
        clear = true;
    }//GEN-LAST:event_jbClearActionPerformed

    private void jbEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEndActionPerformed
        jbConnect.setEnabled(false);
        jbDisconnect.setEnabled(true);
        jbStart.setEnabled(true);
        jbStop.setEnabled(false);
        jbClear.setEnabled(false);
        jbEnd.setEnabled(true);
        
        end = true;
    }//GEN-LAST:event_jbEndActionPerformed

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
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client().setVisible(true);
            }
        });
    }
    
    
    
    private class MyConnectionWorker extends ConnectionWorker{
        
        private Socket socket;
        private Response resp;
        
        public MyConnectionWorker(int port, String hostName) {
            super(port, hostName);
        }

            protected String doInBackground() throws Exception{

            final Gson g = new Gson();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());

            while(true){
                try{
                    final Request req = new Request(true, start, stop, clear, end);
                    final String reqString = g.toJson(req);
                    writer.write(reqString);
                    writer.flush();

                    start = false;
                    stop = false;
                    clear = false;
                    end = false; 
                    
                    final String respString = reader.readLine();
                    final Response resp = g.fromJson(respString, Response.class);
                    publish(resp);
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }


        protected void process(List<Response> list) {
            Response resp = list.get(0);
            
            if(resp.isMaster()){
                jbConnect.setEnabled(false);
                jbDisconnect.setEnabled(true);
                jbStart.setEnabled(true);
                jbStop.setEnabled(false);
                jbClear.setEnabled(false);
                jbEnd.setEnabled(true);
            }
            
            if(resp.isRunning()){
                jTimer.setText(String.format("%.3f", resp.getTime()));
            }
        }
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private java.awt.Label jTimer;
    private javax.swing.JButton jbClear;
    private javax.swing.JButton jbConnect;
    private javax.swing.JButton jbDisconnect;
    private javax.swing.JButton jbEnd;
    private javax.swing.JButton jbStart;
    private javax.swing.JButton jbStop;
    private javax.swing.JSlider jsRefreshrate;
    // End of variables declaration//GEN-END:variables

}
    

