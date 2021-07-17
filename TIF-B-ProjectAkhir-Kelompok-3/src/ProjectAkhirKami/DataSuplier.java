/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectAkhirKami;

import com.mysql.jdbc.Statement;
<<<<<<< HEAD
import java.awt.Color;
=======
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.Connectionz;

/**
 *
 * @author asus
 */
public class DataSuplier extends javax.swing.JFrame {


    /**
     * Creates new form DataSuplier
     */
    private DefaultTableModel tabmode;
    
    public DataSuplier() {
        initComponents();
        datatable();
<<<<<<< HEAD

    }
        private DefaultTableModel tabmode;
      public void noTable(){
=======
        lebarKolom();
        autoIDSuplier();
        txtIDSuplier.requestFocus();
        setLocationRelativeTo(this);
    }
    
    public void noTable(){
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
        int Baris = tabmode.getRowCount();
        for (int a=0; a<Baris; a++)
        {
            String nomor = String.valueOf(a+1);
            tabmode.setValueAt(nomor +".",a,0);
        }
<<<<<<< HEAD
=======
    }
    
    protected void kosong(){
        txtIDSuplier.setText(null);
        txtNamaPerusahaan.setText(null);
        txtNoHp.setText(null);
        txtAlamat.setText(null);
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
    }
      
      
    
    public void datatable() {

        Object[] Baris = {"No","ID Suplier","Nama Perusahaan","No Hp","Alamat"};
        tabmode = new DefaultTableModel(null, Baris);
        tabel.setModel(tabmode);
        String sql = "select * from tblsuplier order by id_suplier asc";
        try{
            java.sql.Statement stat = Connectionz.GetConnection().createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String idsup = hasil.getString("id_suplier");
                String namaper = hasil.getString("nama_perusahaan");
                String nohp = hasil.getString("no_hp");
                String alamat = hasil.getString("alamat");
                String[] data = {"",idsup,namaper,nohp,alamat};
                tabmode.addRow(data);
                noTable();
            }
        } catch (Exception e){
        }
    }
    
    public void lebarKolom(){
        TableColumn column;
        tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel.getColumnModel().getColumn(0);
        column.setPreferredWidth(40);
        column = tabel.getColumnModel().getColumn(1);
        column.setPreferredWidth(100);
        column = tabel.getColumnModel().getColumn(2);
        column.setPreferredWidth(190);
        column = tabel.getColumnModel().getColumn(3);
        column.setPreferredWidth(150);
        column = tabel.getColumnModel().getColumn(4);
        column.setPreferredWidth(200);
    }
    
    public void pencarian(String sql){
        Object[] Baris = {"No","ID Suplier","Nama Perusahaan","No Hp","Alamat"};
        tabmode = new DefaultTableModel(null, Baris);
        tabel.setModel(tabmode);
        int brs = tabel.getRowCount();
        for (int i = 0; 1 < brs; i++){
            tabmode.removeRow(1);
        }
        try{
            java.sql.Statement stat = Connectionz.GetConnection().createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String idsup = hasil.getString("id_suplier");
                String namaper = hasil.getString("nama_perusahaan");
                String nohp = hasil.getString("no_hp");
                String alamat = hasil.getString("alamat");
                String[] data = {"",idsup,namaper,nohp,alamat};
                tabmode.addRow(data);
                noTable();
            }
        } catch(Exception e){
        }
    }
    
<<<<<<< HEAD
private void autoIDSuplier() {
=======
    private void autoIDSuplier() {
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
        try {
            Connection con = new Connectionz().GetConnection();
            java.sql.Statement stat = con.createStatement();
            String sql = "select max(right (id_suplier,3)) as no from tblsuplier";
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                if (res.first() == false) {
                    txtIDSuplier.setText("S-0001");
                } else {
                    res.last();
                    int aut_id = res.getInt(1) + 1;
                    String no = String.valueOf(aut_id);
                    int no_sup = no.length();
                    // mengatur jumlah 0
                    for (int j = 0; j < 3 - no_sup; j++) {
                        no = "0" + no;
                    }
                    txtIDSuplier.setText("S-" + no);
                }
            }
            res.close();
            stat.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan");
        }
    }
  public void lebarKolom(){
        TableColumn column;
        tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel.getColumnModel().getColumn(0);
        column.setPreferredWidth(40);
        column = tabel.getColumnModel().getColumn(1);
        column.setPreferredWidth(100);
        column = tabel.getColumnModel().getColumn(2);
        column.setPreferredWidth(150);
        column = tabel.getColumnModel().getColumn(3);
        column.setPreferredWidth(150);
        column = tabel.getColumnModel().getColumn(4);
        column.setPreferredWidth(100);
    }
    
    public void pencarian(String sql){
        Object[] Baris = {"No","ID Suplier","Nama Perusahaan","No Hp","Alamat"};
        tabmode = new DefaultTableModel(null, Baris);
        tabel.setModel(tabmode);
        int brs = tabel.getRowCount();
        for (int i = 0; 1 < brs; i++){
            tabmode.removeRow(1);
        }
        try{
            java.sql.Statement stat = Connectionz.GetConnection().createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String idsup = hasil.getString("id_suplier");
                String namaper = hasil.getString("nama_perusahaan");
                String nohp = hasil.getString("no_hp");
                String alamat = hasil.getString("alamat");
                String[] data = {"",idsup,namaper,nohp,alamat};
                tabmode.addRow(data);
                noTable();
            }
        } catch(Exception e){
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBackSuplier = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btntambah = new javax.swing.JButton();
<<<<<<< HEAD
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
=======
        txtCari = new javax.swing.JTextField();
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIDSuplier = new javax.swing.JTextField();
        txtNamaPerusahaan = new javax.swing.JTextField();
        txtNoHp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        btnsimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(246, 229, 233));

        btnBackSuplier.setBackground(new java.awt.Color(231, 152, 174));
        btnBackSuplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBackSuplier.setForeground(new java.awt.Color(74, 28, 64));
        btnBackSuplier.setText("KEMBALI");
        btnBackSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackSuplierActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 39)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(74, 28, 64));
        jLabel1.setText("DATA SUPLIER");

        btntambah.setBackground(new java.awt.Color(231, 152, 174));
        btntambah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btntambah.setForeground(new java.awt.Color(74, 28, 64));
        btntambah.setText("TAMBAH");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(74, 28, 64));
        jLabel2.setText("SEARCH");

        txtSearch.setForeground(new java.awt.Color(153, 153, 153));
        txtSearch.setText("Masukkan Nama / ID Suplier");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
=======
        txtCari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCari.setForeground(new java.awt.Color(74, 28, 64));
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKeyTyped(evt);
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectAkhirKami/1_1_1_e790ae2c-67a6-45b9-a1dd-d70b127f5322-removebg-preview.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel14.setText("Ilnaa Collection");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("ID Suplier");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nama Perusahaan");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("No Hp");

<<<<<<< HEAD
=======
        txtIDSuplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
        txtIDSuplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDSuplierKeyPressed(evt);
            }
        });

<<<<<<< HEAD
=======
        txtNamaPerusahaan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
        txtNamaPerusahaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaPerusahaanKeyPressed(evt);
            }
        });

<<<<<<< HEAD
=======
        txtNoHp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
        txtNoHp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoHpKeyPressed(evt);
            }
        });

<<<<<<< HEAD
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
=======
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
        jLabel6.setText("Alamat");

        txtAlamat.setColumns(20);
        txtAlamat.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtAlamat.setRows(5);
        txtAlamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAlamatKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txtAlamat);

        btnsimpan.setBackground(new java.awt.Color(231, 152, 174));
        btnsimpan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnsimpan.setText("SIMPAN");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        btnHapus.setBackground(new java.awt.Color(231, 152, 174));
        btnHapus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setBackground(new java.awt.Color(231, 152, 174));
        btnBatal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(231, 152, 174));
        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("CARI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(jLabel1))
                    .addComponent(btnBackSuplier))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(76, 76, 76))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btntambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIDSuplier)
                            .addComponent(txtNamaPerusahaan)
                            .addComponent(txtNoHp)
<<<<<<< HEAD
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCari)))
                        .addGap(19, 19, 19)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
=======
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(76, 76, 76))
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBackSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel14)))
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
<<<<<<< HEAD
                            .addComponent(jLabel2)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCari))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
=======
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
                            .addComponent(jLabel3)
                            .addComponent(txtIDSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNamaPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        if (txtIDSuplier.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ID Suplier tidak boleh kosong");
            txtIDSuplier.requestFocus();
        } else if (txtNamaPerusahaan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Perusahaan tidak boleh kosong");
            txtNamaPerusahaan.requestFocus();
        } else if (txtNoHp.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No Hp tidak boleh kosong");
            txtNoHp.requestFocus();
        } else if (txtAlamat.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Alamat tidak boleh kosong");
            txtAlamat.requestFocus();
        } else {
            String sql = "insert into tblsuplier values (?,?,?,?)";
            try {
                PreparedStatement stat = Connectionz.GetConnection().prepareStatement(sql);
                stat.setString(1, txtIDSuplier.getText());
                stat.setString(2, txtNamaPerusahaan.getText());
                stat.setString(3, txtNoHp.getText());
                stat.setString(4, txtAlamat.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                autoIDSuplier();
                kosong();
                datatable();
                lebarKolom();
                txtIDSuplier.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan" + e);
            }
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        txtIDSuplier.setText("");
        txtNamaPerusahaan.setText("");
        txtNoHp.setText("");
        txtAlamat.setText("");
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        String idsup = txtIDSuplier.getText();
        try {
            Statement statement = (Statement)Connectionz.GetConnection() .createStatement();
            statement.executeUpdate("DELETE from tblsuplier where id_suplier=('" +idsup+ "');");
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            txtIDSuplier.setText("");
            txtNamaPerusahaan.setText("");
            txtNoHp.setText("");
            txtAlamat.setText("");
            txtIDSuplier.requestFocus();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        }
        datatable();
        lebarKolom();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        txtIDSuplier.setText("");
        txtNamaPerusahaan.setText("");
        txtNoHp.setText("");
        txtAlamat.setText("");
    }//GEN-LAST:event_btnBatalActionPerformed

<<<<<<< HEAD
    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        try {
            Statement statement = (Statement)Connectionz.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from tblsuplier where + "
            + "id_suplier='" + txtSearch.getText() + "'");
            DefaultTableModel tbl= new DefaultTableModel();
            tbl.addColumn("ID Suplier");
            tbl.addColumn("Nama Perusahaan");
            tbl.addColumn("No Hp");
            tbl.addColumn("Alamat");
            
            tabel.setModel(tbl);
            while (res.next()){
                tbl.addRow(new Object[] {
                    res.getString("id_suplier"),
                    res.getString("nama_perusahaan"),
                    res.getString("no_hp"),
                    res.getString("alamat"),
                    });
                    tabel.setModel(tbl);      
            }
        }  
        catch (Exception e) {
                  JOptionPane.showMessageDialog(rootPane, "salah");
        }
    }//GEN-LAST:event_btnCariActionPerformed

=======
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
    private void btnBackSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackSuplierActionPerformed
        // TODO add your handling code here:
        Admin adm=new Admin();
        adm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackSuplierActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        
         
        String idSuplier = txtIDSuplier.getText();
        String namaPerusahaan = txtNamaPerusahaan.getText();
        String noHp = txtNoHp.getText();
        String alamatSuplier = txtAlamat.getText();

        
        
        try{
        java.sql.Statement statement = (java.sql.Statement) Connectionz.GetConnection().createStatement();
        statement.executeUpdate("update tblsuplier set nama_perusahaan = '"+namaPerusahaan+"' , no_hp= '"+noHp+"', alamat= '"+alamatSuplier+"' where id_suplier = '"+idSuplier+"' ");
        statement.close();
            JOptionPane.showMessageDialog(null, " Data Berhasil Diubah");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, " Data Gagal Dubah");
        }
        datatable();
        lebarKolom();
    }//GEN-LAST:event_btnEditActionPerformed

<<<<<<< HEAD
    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        // TODO add your handling code here:
                if (txtSearch.getText().equals("Masukkan Nama / ID Suplier"))
        {
            txtSearch.setText("");
            txtSearch.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        // TODO add your handling code here:
        if (txtSearch.getText().equals(""))
        {
            txtSearch.setText("Masukkan Nama / ID Suplier");
            txtSearch.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        // TODO add your handling code here:
          String sqlPencarian = "select * from tblsuplier where id_suplier like '%"+txtSearch.getText()+"%' or nama_perusahaan like '%"+txtSearch.getText()+"%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_txtSearchKeyTyped
=======
    private void txtIDSuplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDSuplierKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtNamaPerusahaan.requestFocus();
        }
    }//GEN-LAST:event_txtIDSuplierKeyPressed

    private void txtNamaPerusahaanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaPerusahaanKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtNoHp.requestFocus();
        }
    }//GEN-LAST:event_txtNamaPerusahaanKeyPressed

    private void txtNoHpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoHpKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtAlamat.requestFocus();
        }
    }//GEN-LAST:event_txtNoHpKeyPressed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        // TODO add your handling code here:
        String sqlPencarian = "select * from tblsuplier where id_suplier like '%"+txtCari.getText()+"%' or nama_perusahaan like '%"+txtCari.getText()+"%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_txtCariKeyTyped
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        int bar = tabel.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        txtIDSuplier.setText(b);
        txtIDSuplier.requestFocus();
    }//GEN-LAST:event_tabelMouseClicked

<<<<<<< HEAD
    private void txtIDSuplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDSuplierKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtIDSuplier.requestFocus();
        }
    }//GEN-LAST:event_txtIDSuplierKeyPressed

    private void txtNamaPerusahaanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaPerusahaanKeyPressed
        // TODO add your handling code here:
                if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtNamaPerusahaan.requestFocus();
        }
    }//GEN-LAST:event_txtNamaPerusahaanKeyPressed

    private void txtNoHpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoHpKeyPressed
        // TODO add your handling code here:
                if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtNoHp.requestFocus();
        }
    }//GEN-LAST:event_txtNoHpKeyPressed

    private void txtAlamatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlamatKeyPressed
        // TODO add your handling code here:
                if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtAlamat.requestFocus();
        }
    }//GEN-LAST:event_txtAlamatKeyPressed

=======
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
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
            java.util.logging.Logger.getLogger(DataSuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataSuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataSuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataSuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataSuplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackSuplier;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIDSuplier;
    private javax.swing.JTextField txtNamaPerusahaan;
    private javax.swing.JTextField txtNoHp;
<<<<<<< HEAD
    private javax.swing.JTextField txtSearch;
=======
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
    // End of variables declaration//GEN-END:variables
}
