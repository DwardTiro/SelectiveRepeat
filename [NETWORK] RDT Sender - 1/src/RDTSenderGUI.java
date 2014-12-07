
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.ArrayList;


public class RDTSenderGUI extends javax.swing.JFrame {
    
    private DatagramSocket senderSocket;
    private ArrayList<Packet> packetList;
    
    public RDTSenderGUI() {
        initComponents();
    }

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
        ChunkSizeLabel = new javax.swing.JLabel();
        ChunkSizeTextField = new javax.swing.JTextField();
        WindowSizeLabel = new javax.swing.JLabel();
        WindowSizeTextField = new javax.swing.JTextField();
        SequenceNumberLabel = new javax.swing.JLabel();
        SequenceNumberTextField = new javax.swing.JTextField();
        TimeoutLabel = new javax.swing.JLabel();
        TimeoutTextField = new javax.swing.JTextField();
        LossProbabilityLabel = new javax.swing.JLabel();
        LossProbabilityTextField = new javax.swing.JTextField();
        DelayLabel = new javax.swing.JLabel();
        DelayTextField = new javax.swing.JTextField();
        ReceiverIPAddressLabel = new javax.swing.JLabel();
        ReceiverIPAddressTextField = new javax.swing.JTextField();
        PortNumberLabel = new javax.swing.JLabel();
        PortNumberTextField = new javax.swing.JTextField();
        StatusLabel = new javax.swing.JLabel();
        StatusScrollPane = new javax.swing.JScrollPane();
        StatusTextArea = new javax.swing.JTextArea();
        TransferButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Network UDP-Based Reliable File Transfer Sender");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeaderPanel.setBackground(new java.awt.Color(51, 51, 51));

        NetworkLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/The Network Logo Small.png"))); // NOI18N

        ProgramNameLabel.setFont(new java.awt.Font("Ebrima", 0, 26)); // NOI18N
        ProgramNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        ProgramNameLabel.setText("NETWORK UDP-BASED RELIABLE FILE TRANSFER SENDER");

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

        ChunkSizeLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ChunkSizeLabel.setText("Chunk size (in bytes)");

        WindowSizeLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        WindowSizeLabel.setText("Window size (in bytes)");

        SequenceNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        SequenceNumberLabel.setText("Initial Sequence Number");

        TimeoutLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        TimeoutLabel.setText("Timeout (in milliseconds)");

        LossProbabilityLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        LossProbabilityLabel.setText("Loss Probability");

        DelayLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        DelayLabel.setText("Delay between transmission");

        ReceiverIPAddressLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ReceiverIPAddressLabel.setText("Receiver IP Address");

        PortNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PortNumberLabel.setText("Port Number");

        StatusLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        StatusLabel.setText("Status");

        StatusTextArea.setEditable(false);
        StatusTextArea.setColumns(20);
        StatusTextArea.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        StatusTextArea.setRows(5);
        StatusScrollPane.setViewportView(StatusTextArea);

        TransferButton.setText("Transfer!");
        TransferButton.setMinimumSize(new java.awt.Dimension(56, 23));
        TransferButton.setPreferredSize(new java.awt.Dimension(56, 23));
        TransferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TimeoutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(StatusLabel)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(SequenceNumberLabel)
                                .addComponent(LossProbabilityLabel)
                                .addComponent(ReceiverIPAddressLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(MainPanelLayout.createSequentialGroup()
                                    .addComponent(SequenceNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TimeoutLabel))
                                .addGroup(MainPanelLayout.createSequentialGroup()
                                    .addComponent(ReceiverIPAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(PortNumberLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(PortNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(MainPanelLayout.createSequentialGroup()
                                    .addComponent(LossProbabilityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(DelayLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(DelayTextField))))
                        .addGroup(MainPanelLayout.createSequentialGroup()
                            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(FileNameLabel)
                                .addComponent(ChunkSizeLabel))
                            .addGap(37, 37, 37)
                            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(MainPanelLayout.createSequentialGroup()
                                    .addComponent(ChunkSizeTextField)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(WindowSizeLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(WindowSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(FileNameTextField)))
                        .addComponent(StatusScrollPane)
                        .addComponent(TransferButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(ChunkSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChunkSizeLabel)
                    .addComponent(WindowSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WindowSizeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SequenceNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SequenceNumberLabel)
                    .addComponent(TimeoutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimeoutLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LossProbabilityLabel)
                    .addComponent(LossProbabilityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelayLabel)
                    .addComponent(DelayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ReceiverIPAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PortNumberLabel)
                        .addComponent(PortNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ReceiverIPAddressLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StatusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StatusScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransferButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 780, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TransferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferButtonActionPerformed
        String filePath;
        int chunkSize;
        int windowSizeInByte;
        int windowSizeSlot;
        int initialSequenceNumber;
        int timeout;
        int lossProbability;
        int delay;
        InetAddress receiverIPAddress;
        int receiverPortNumber;
        
        DatagramPacket sendPacket;
        String wholeData = "";
        String chunkData;
        byte[] tempBytes = null;
        char[] tempChars;
        
        try{
            
         //---------GETS VALUES FROM TEXTFIELDS
            // gets fileName
            filePath = FileNameTextField.getText();
            
            // gets chunkSize
            chunkSize = Integer.parseInt(ChunkSizeTextField.getText());
            
            // gets windowSizeInByte and windowSizeSlot
            windowSizeInByte = Integer.parseInt(WindowSizeTextField.getText());
            windowSizeSlot = windowSizeInByte/chunkSize;
            
            // gets initialSequenceNumber
            initialSequenceNumber = Integer.parseInt(SequenceNumberTextField.getText());
            
            // gets timeout
            timeout = Integer.parseInt(TimeoutTextField.getText());
            
            // gets lossProbability
            lossProbability = Integer.parseInt(LossProbabilityTextField.getText());
            
            // gets delay
            delay = Integer.parseInt(DelayTextField.getText());
            
            // gets receiverIPAddress
            receiverIPAddress = InetAddress.getByName(ReceiverIPAddressTextField.getText());
            
            // gets receiverPortNumber
            receiverPortNumber = Integer.parseInt(PortNumberTextField.getText());
            
            
         //---------CREATES SOCKET AND SETS TIMEOUT
            senderSocket = new DatagramSocket();
            senderSocket.setSoTimeout(timeout);
            
            
         //---------GETS FILE
            File file = new File(filePath);
            byte[] fileByte = Files.readAllBytes(file.toPath());
            
        
         //---------SENDS DATA SIZE
            byte[] dataSizeBytes = Integer.toString(fileByte.length).getBytes();
            sendPacket = new DatagramPacket(dataSizeBytes, dataSizeBytes.length, receiverIPAddress, receiverPortNumber);
            senderSocket.send(sendPacket);
            
         //---------SENDS FILE NAME
            byte[] fileNameBytes = filePath.getBytes();
            sendPacket = new DatagramPacket(fileNameBytes, fileNameBytes.length, receiverIPAddress, receiverPortNumber);
            senderSocket.send(sendPacket);
            
         //---------CHANGE FILE BYTES ARRAY TO CHAR ARRAY
            char[] tempCharArr = new char[fileByte.length];
            for(int i =0; i < fileByte.length; i++){
                tempCharArr[i] = (char)fileByte[i];
                wholeData += tempCharArr[i];
            }
            
         //---------SPLIT
            packetList = new ArrayList<>();
            for(int i = 0; i < fileByte.length; i += chunkSize)
            {
                if((i + chunkSize) < fileByte.length)
                {
                    tempBytes = new byte[chunkSize];
                    chunkData = wholeData.substring(i, i + chunkSize);
                
                    //char to bytes
                    tempChars = chunkData.toCharArray();
                    for(int j = 0; j < tempChars.length; j++)
                    {
                        tempBytes[j] = (byte)tempChars[j];
                    }
                }
                
                else if((i + chunkSize) > fileByte.length)
                {
                    tempBytes = new byte[fileByte.length % chunkSize];
                    chunkData = wholeData.substring(i, fileByte.length);
                
                    //char to bytes
                    tempChars = chunkData.toCharArray();
                    for(int j = 0; j < tempChars.length; j++)
                    {
                        tempBytes[j] = (byte)tempChars[j];
                    }
                }
                packetList.add(new Packet(initialSequenceNumber, tempBytes));
                initialSequenceNumber++;
            }
            
        } catch(UnknownHostException e){
            e.printStackTrace();
        } catch(SocketException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_TransferButtonActionPerformed
    
    public boolean generateLossProb(int percent){
        boolean isLost= false;
        float bound;
        int rand = (int)(Math.random()* 10+1);
        bound = percent/10;
        if(bound >= rand)
            isLost=true;
        return isLost;
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
            java.util.logging.Logger.getLogger(RDTSenderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RDTSenderGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ChunkSizeLabel;
    private javax.swing.JTextField ChunkSizeTextField;
    private javax.swing.JLabel DelayLabel;
    private javax.swing.JTextField DelayTextField;
    private javax.swing.JLabel FileNameLabel;
    private javax.swing.JTextField FileNameTextField;
    private javax.swing.JLabel GoBackNTextLabel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JLabel LossProbabilityLabel;
    private javax.swing.JTextField LossProbabilityTextField;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel NetworkLogoLabel;
    private javax.swing.JLabel PortNumberLabel;
    private javax.swing.JTextField PortNumberTextField;
    private javax.swing.JLabel ProgramNameLabel;
    private javax.swing.JLabel ReceiverIPAddressLabel;
    private javax.swing.JTextField ReceiverIPAddressTextField;
    private javax.swing.JLabel SequenceNumberLabel;
    private javax.swing.JTextField SequenceNumberTextField;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JScrollPane StatusScrollPane;
    private javax.swing.JTextArea StatusTextArea;
    private javax.swing.JLabel TimeoutLabel;
    private javax.swing.JTextField TimeoutTextField;
    private javax.swing.JButton TransferButton;
    private javax.swing.JLabel WindowSizeLabel;
    private javax.swing.JTextField WindowSizeTextField;
    // End of variables declaration//GEN-END:variables
}
