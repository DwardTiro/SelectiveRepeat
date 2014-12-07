
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RDTReceiverGUI extends javax.swing.JFrame {
    //Variable Declaration
    private DatagramSocket receiverSocket;
    private byte[] receiveChunk, receiveData, sendAck;
    private int dataSize, senderPort;
    private DatagramPacket receivePacket, sendPacket;
    private String port;
    private ArrayList<Packet> packetList;
    private InetAddress senderIPAddress;
    // initializes components, objects and variables
    public RDTReceiverGUI() {
        //initializes GUI components
        initComponents();
        dataSize = 0;
        receiveChunk = new byte[1000];
        port = JOptionPane.showInputDialog(null, "Enter port number", "The Network", 3);
        new ReceiverThread().start();
    }

    // initializes GUI components
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeaderPanel = new javax.swing.JPanel();
        NetworkLogoLabel = new javax.swing.JLabel();
        ProgramNameLabel = new javax.swing.JLabel();
        GoBackNTextLabel = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        FileNameLabel = new javax.swing.JLabel();
        FileNameTextField = new javax.swing.JTextField();
        WindwSizeLabel = new javax.swing.JLabel();
        WindowSizeTextField = new javax.swing.JTextField();
        TimeoutLabel = new javax.swing.JLabel();
        TimeoutTextField = new javax.swing.JTextField();
        LossProbabilityLabel = new javax.swing.JLabel();
        StatusLabel = new javax.swing.JLabel();
        StatusScrollPane = new javax.swing.JScrollPane();
        StatusTextArea = new javax.swing.JTextArea();
        LossProbabilityTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeaderPanel.setBackground(new java.awt.Color(51, 51, 51));

        NetworkLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/The Network Logo Small.png"))); // NOI18N

        ProgramNameLabel.setFont(new java.awt.Font("Ebrima", 0, 25)); // NOI18N
        ProgramNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        ProgramNameLabel.setText("NETWORK UDP-BASED RELIABLE FILE TRANSFER RECEIVER");

        GoBackNTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        GoBackNTextLabel.setText("TCP RELIABLE DATA TRANSFER");

        javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(NetworkLogoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ProgramNameLabel)
                    .addComponent(GoBackNTextLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NetworkLogoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ProgramNameLabel)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(GoBackNTextLabel)
                .addContainerGap())
        );

        getContentPane().add(HeaderPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, -1));

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));

        FileNameLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        FileNameLabel.setText("File Name");

        FileNameTextField.setBackground(new java.awt.Color(255, 255, 255));

        WindwSizeLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        WindwSizeLabel.setText("Window size (in bytes)");

        WindowSizeTextField.setBackground(new java.awt.Color(255, 255, 255));

        TimeoutLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        TimeoutLabel.setText("Timeout (in milliseconds)");

        TimeoutTextField.setBackground(new java.awt.Color(255, 255, 255));

        LossProbabilityLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        LossProbabilityLabel.setText("Loss Probability");

        StatusLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        StatusLabel.setText("Status");

        StatusTextArea.setEditable(false);
        StatusTextArea.setColumns(20);
        StatusTextArea.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        StatusTextArea.setRows(5);
        StatusScrollPane.setViewportView(StatusTextArea);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StatusLabel)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FileNameLabel)
                            .addComponent(TimeoutLabel))
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(FileNameTextField))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(LossProbabilityTextField)
                                    .addComponent(TimeoutTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(WindwSizeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(WindowSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(StatusScrollPane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                        .addComponent(LossProbabilityLabel)
                        .addGap(507, 507, 507)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(FileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FileNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(WindowSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(WindwSizeLabel)
                        .addComponent(TimeoutLabel)
                        .addComponent(TimeoutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LossProbabilityLabel)
                    .addComponent(LossProbabilityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StatusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StatusScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 780, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public class ReceiverThread extends Thread{
        private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] tempByte = null;
        int tempsize = 0;
        int sequenceNum;
        boolean isDuplicate = false;
        
        public void run(){
            int windowsize;
           // if(!TimeoutTextField.getText().isEmpty()&&FileNameTextField.getText().isEmpty()&&WindowSizeTextField.getText().isEmpty()&&LossProbabilityTextField.getText().isEmpty()){
            while(true){
            try{
                synchronized(baos){
                receiverSocket = new DatagramSocket(Integer.parseInt(port));
                packetList = new ArrayList<>();
                System.out.println(port);
                receiverSocket.setSoTimeout(Integer.parseInt(TimeoutTextField.getText()));
                dataSize = 0;
                windowsize = Integer.parseInt(WindowSizeTextField.getText());
                
                do{
                    receivePacket = new DatagramPacket(receiveChunk, receiveChunk.length);
                    receiverSocket.receive(receivePacket);
                    
                    baos.write(receivePacket.getData(),  0, receivePacket.getLength());
                    sequenceNum = Integer.parseInt(baos.toString());
                    baos.reset();
                    
                }
                while(true);
                
                }
            }
            catch(SocketException s){}
            catch(IOException i){}
            }
        }
    }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RDTReceiverGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RDTReceiverGUI().setVisible(true);
            }
        });
    }
    
    public boolean generateLossProb(int percent){
        float bound;
        boolean isLoss = false;
        int random = (int)(Math.random() * 10 + 1);
        bound = percent / 10;
        if(random <= bound)
            isLoss = true;
        
        return isLoss;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FileNameLabel;
    private javax.swing.JTextField FileNameTextField;
    private javax.swing.JLabel GoBackNTextLabel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JLabel LossProbabilityLabel;
    private javax.swing.JTextField LossProbabilityTextField;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel NetworkLogoLabel;
    private javax.swing.JLabel ProgramNameLabel;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JScrollPane StatusScrollPane;
    private javax.swing.JTextArea StatusTextArea;
    private javax.swing.JLabel TimeoutLabel;
    private javax.swing.JTextField TimeoutTextField;
    private javax.swing.JTextField WindowSizeTextField;
    private javax.swing.JLabel WindwSizeLabel;
    // End of variables declaration//GEN-END:variables
}
