
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JP
 */
public class CFrame extends javax.swing.JFrame {

    public CFrame() {
        initComponents();
    }
    DataInputStream entrada = null;
    DataOutputStream salida = null;

    Socket clienteSocket;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();
        txtfield = new javax.swing.JTextField();
        bsend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtarea.setColumns(20);
        txtarea.setRows(5);
        jScrollPane1.setViewportView(txtarea);

        bsend.setText("ENVIAR");
        bsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bsend, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfield, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(bsend, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsendActionPerformed

        
      
    }//GEN-LAST:event_bsendActionPerformed

    public static void main(String args[]) throws IOException {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CFrame().setVisible(true);
            }
        });

        CFrame cf = new CFrame();
        cf.Conexion();
        cf.enviarDatos();
       

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bsend;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtarea;
    private javax.swing.JTextField txtfield;
    // End of variables declaration//GEN-END:variables

    public void Conexion() {

        try {
            System.out.println("Creando socket cliente");
            clienteSocket = new Socket();
            System.out.println("Estableciendo la conexion");

            InetSocketAddress direc = new InetSocketAddress("localhost", 6000);
            clienteSocket.connect(direc);
        } catch (IOException ex) {
            Logger.getLogger(CFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void enviarDatos() throws IOException{
    
        while(true){
            String msj=null;
            
            salida=new DataOutputStream(clienteSocket.getOutputStream());
            
            msj=JOptionPane.showInputDialog("Inserte un mensaje: ");
            salida.writeUTF(msj);
            
            
       
        }
    
    }
    
    
    
}
