/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectAkhirKami;

import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.Connectionz;

/**
 *
 * @author asus
 */
public class DataUser extends javax.swing.JFrame {

    private DefaultTableModel tabmode;
    /**
     * Creates new form DataUser
     */
    public DataUser() {
        initComponents();
        aktif();
        datatable();
        txtIDUser.requestFocus();
        setLocationRelativeTo(this);
    }
    
    private void kosongkan_Form(){
          txtIDUser.setEditable(true);
          txtNamaDepan.setText("");
          txtNamaBelakang.setText("");
          btnGrp.clearSelection();
          txtNoHp.setText("");
          txtAlamat.setText("");
          txtLevel.setText("");
          txtPassword.setText("");
          txtIDUser.requestFocus();
    
    }
    
    private void aktif(){
        txtIDUser.setEnabled(true);
        txtNamaDepan.setEnabled(true);
        txtNamaBelakang.setEnabled(true);
        jComboBox1.setEnabled(true);
        txtNoHp.setEnabled(true);
        txtAlamat.setEnabled(true);
        txtLevel.setEnabled(true);
        txtPassword.setEnabled(true);
    }
            private DefaultTableModel tabmode;
      public void noTable(){
        int Baris = tabmode.getRowCount();
        for (int a=0; a<Baris; a++)
        {
            String nomor = String.valueOf(a+1);
            tabmode.setValueAt(nomor +".",a,0);
        }
    }
    
    public void datatable() {

        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID User");
        tbl.addColumn("Nama Depan");
        tbl.addColumn("Nama Belakang");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("No Hp");
        tbl.addColumn("Alamat");
        tbl.addColumn(" Level");
        tbl.addColumn("Password");
        tabel.setModel(tbl);
        try {
            Statement statement = (Statement) Connectionz.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from tbluser order by id_user asc");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_user"),
                    res.getString("nama_depan"),
                    res.getString("nama_belakang"),
                    res.getString("jenis_kelamin"),
                    res.getString("no_hp"),
                    res.getString("alamat"),
                    res.getString("level"),
                    res.getString("password"),});
                tabel.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah");
        }
    }
    
<<<<<<< HEAD
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
        Object[] Baris = {"No","ID User","Nama Depan","Nama Belakang","Jenis Kelamin","No Hp","Alamat","Level","Password"};
=======
    public void pencarian(String sql){
        Object[] Baris = {"ID User","Nama Depan","Nama Belakang","Jenis kelamin","No Hp","Alamat","Level","Password"};
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
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
<<<<<<< HEAD
                String idUs = hasil.getString("id_user");
                String namaDep = hasil.getString("nama_depan");
                String namaBel = hasil.getString("nama_belakang");
                String nohp = hasil.getString("no_hp");
                String alamat = hasil.getString("alamat");
                String level = hasil.getString("level");
                String password = hasil.getString("password");
                String[] data = {"",idUs,namaDep,namaBel,nohp,alamat,level,password};
                tabmode.addRow(data);
                noTable();
=======
                String iduser = hasil.getString("id_user");
                String namadep = hasil.getString("nama_depan");
                String namabel = hasil.getString("nama_belakang");
                String jeniskel = hasil.getString("jenis_kelamin");
                String nohp = hasil.getString("no_hp");
                String alamat = hasil.getString("alamat");
                String level = hasil.getString("level");
                String pass = hasil.getString("password");
                String[] data = {iduser,namadep,namabel,jeniskel,nohp,alamat,level,pass};
                tabmode.addRow(data);
                //noTable();
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
            }
        } catch(Exception e){
        }
    }
<<<<<<< HEAD

=======
    
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrp = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBackUser = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
<<<<<<< HEAD
        txtcariUs = new javax.swing.JTextField();
=======
        txtCari = new javax.swing.JTextField();
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIDUser = new javax.swing.JTextField();
        txtNamaDepan = new javax.swing.JTextField();
        txtNamaBelakang = new javax.swing.JTextField();
        txtNoHp = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        txtLevel = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btUsrEdit = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(246, 229, 233));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 39)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(74, 28, 64));
        jLabel1.setText("DATA USER");

        btnBackUser.setBackground(new java.awt.Color(231, 152, 174));
        btnBackUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBackUser.setForeground(new java.awt.Color(74, 28, 64));
        btnBackUser.setText("KEMBALI");
        btnBackUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackUserActionPerformed(evt);
            }
        });

        btnTambah.setBackground(new java.awt.Color(231, 152, 174));
        btnTambah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(74, 28, 64));
        btnTambah.setText("TAMBAH");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(74, 28, 64));
        jLabel2.setText("CARI");

<<<<<<< HEAD
        txtcariUs.setForeground(new java.awt.Color(153, 153, 153));
        txtcariUs.setText("Masukkan ID / Nama User");
        txtcariUs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcariUsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcariUsFocusLost(evt);
            }
        });
        txtcariUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariUsActionPerformed(evt);
            }
        });
        txtcariUs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariUsKeyPressed(evt);
=======
        txtCari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariMouseClicked(evt);
            }
        });
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

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel13.setText("Ilnaa Collection");

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
        jScrollPane2.setViewportView(tabel);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("ID User");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nama Depan");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nama Belakang");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Jenis Kelamin");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("No Hp");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Alamat");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Level");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Password");

        txtIDUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIDUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDUserKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDUserKeyTyped(evt);
            }
        });

        txtNamaDepan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNamaDepan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaDepanKeyPressed(evt);
            }
        });

        txtNamaBelakang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNamaBelakang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaBelakangKeyPressed(evt);
            }
        });

        txtNoHp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNoHp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoHpActionPerformed(evt);
            }
        });
        txtNoHp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoHpKeyPressed(evt);
            }
        });

        txtAlamat.setColumns(20);
        txtAlamat.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtAlamat.setRows(5);
        txtAlamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAlamatKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(txtAlamat);

        txtLevel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLevel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLevelKeyPressed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(231, 152, 174));
        btnSimpan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

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

        btUsrEdit.setBackground(new java.awt.Color(231, 152, 174));
        btUsrEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btUsrEdit.setText("EDIT");
        btUsrEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsrEditActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnBackUser)
                .addGap(370, 370, 370)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
<<<<<<< HEAD
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtcariUs)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCari))
                            .addComponent(txtIDUser)
=======
                            .addComponent(jLabel3))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLevel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNoHp, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
                            .addComponent(txtNamaDepan)
                            .addComponent(txtNamaBelakang))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btUsrEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jLabel12)
                    .addComponent(btnBackUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
<<<<<<< HEAD
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcariUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(btnCari))
                        .addGap(18, 18, 18)
=======
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNamaDepan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNamaBelakang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnSimpan)
                    .addComponent(btUsrEdit)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addGap(27, 27, 27))
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

    private void btnBackUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackUserActionPerformed
        // TODO add your handling code here:
        Admin adm = new Admin();
        adm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackUserActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        txtIDUser.setText("");
        txtNamaDepan.setText("");
        txtNamaBelakang.setText("");
        jComboBox1.setSelectedItem("");
        txtNoHp.setText("");
        txtLevel.setText("");
        txtPassword.setText("");
           
        
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String  id_user = txtIDUser.getText();
        String nama_depan = txtNamaDepan.getText();
        String nama_belakang = txtNamaBelakang.getText();
        String jenis_kelamin = (String) jComboBox1.getSelectedItem();
        String no_hp = txtNoHp.getText();
        String alamat = txtLevel.getText();
        String Level = txtLevel.getText();
        String password = txtPassword.getText();
        
        
      
          try {
                Statement statement  = (Statement) Connectionz.GetConnection().createStatement();
                statement.executeUpdate("INSERT INTO tbluser VALUE ('" + id_user + "','" + nama_depan + "','" + nama_belakang + "','" + jenis_kelamin+ "','" + no_hp + "','" +alamat+ "','" +Level+ "','" +password+ "');");
           statement.close();
           JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            }
            datatable();
            kosongkan_Form();
    
        
            
                            
 
       
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        
        String idUser = txtIDUser.getText();
      try{
          com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement)Connectionz.GetConnection().createStatement();
          statement.executeUpdate("DELETE from tbluser where id_user =('" + idUser + "');");
          JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
         
          txtIDUser.setText("");
          txtNamaDepan.setText("");
          txtNamaBelakang.setText("");
          txtNoHp.setText("");
          txtAlamat.setText("");
          txtLevel.setText("");
          txtPassword.setText("");
          txtIDUser.requestFocus();
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, " Data gagal dihapus");
      }
      datatable();
       
       
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btUsrEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsrEditActionPerformed
   
         String sql="update tbluser set id_user='"+ txtIDUser.getText()+
                "',nama_depan='"+txtNamaDepan.getText()+
                 "',nama_belakang='"+txtNamaBelakang.getText()+
                 "',no_hp='"+txtNoHp.getText()+
                 "',alamat='"+txtAlamat.getText()+
                //"',jenis_kelamin='"+ jComboBox1.getSelected()+

                "'where id_user='"+txtIDUser.getText()+"'";
        if(txtIDUser.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Data masih kosong!","Edit Data",JOptionPane.WARNING_MESSAGE);
            txtIDUser.requestFocus();
            }
        else{
            try{
                Statement statement=(Statement) Connectionz.GetConnection().createStatement();
                statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Data Sudah diedit","Edit Data",JOptionPane.WARNING_MESSAGE);
                statement.close();
                //conec.close();
                txtIDUser.requestFocus();
                              
            }
            catch (Exception exc) {
                System.err.println("Error:"+exc);
            }
            datatable();
        
        }
          datatable();
        
    }//GEN-LAST:event_btUsrEditActionPerformed

    private void txtNoHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoHpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoHpActionPerformed

<<<<<<< HEAD
    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
         try{
        com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) Connectionz.GetConnection().createStatement();
        ResultSet res = statement.executeQuery ("select * from tbluser where "
                    + "id_user='" + txtcariUs.getText() + "'");
        DefaultTableModel tb2 = new DefaultTableModel();
        tb2.addColumn("ID User");
        tb2.addColumn("Nama Depan");
        tb2.addColumn("Nama Belakang");
        tb2.addColumn("Jenis Kelamin");
        tb2.addColumn("No Hp");
        tb2.addColumn("Alamat");
        tb2.addColumn("Level");
        tb2.addColumn("Password");

      
        
        tabel.setModel(tb2);
        
        while (res.next()){
            tb2.addRow(new Object[]{
                    res.getString("id_user"),
                    res.getString("nama_depan"),
                    res.getString("nama_belakang"),
                    res.getString("jenis_kelamin"),
                    res.getString("no_hp"),
                    res.getString("alamat"),
                    res.getString("level"),
                    res.getString("password"),

                    
            });
            tabel.setModel(tb2);
    }
    
    }catch(Exception e){
      JOptionPane.showMessageDialog(rootPane, "Maaf Data Anda Salah");
    }

    }//GEN-LAST:event_btnCariActionPerformed

=======
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        txtIDUser.setText("");
        txtNamaDepan.setText("");
        txtNamaBelakang.setText("");
        jComboBox1.setSelectedItem("");
        txtNoHp.setText("");
        txtAlamat.setText("");
        txtLevel.setText("");
        txtPassword.setText("");
    }//GEN-LAST:event_btnBatalActionPerformed

<<<<<<< HEAD
    private void txtcariUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariUsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcariUsActionPerformed
=======
    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d

    private void txtIDUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDUserKeyTyped
        // TODO add your handling code here:
        filterangka(evt);
    }//GEN-LAST:event_txtIDUserKeyTyped

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        // TODO add your handling code here:
        filterhuruf(evt);
        
      
    }//GEN-LAST:event_txtPasswordKeyTyped

<<<<<<< HEAD
    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
           int bar = tabel.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        txtIDUser.setText(b);
        txtIDUser.requestFocus();
        
    }//GEN-LAST:event_tabelMouseClicked

    private void txtcariUsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcariUsFocusGained
        // TODO add your handling code here:
                if (txtcariUs.getText().equals("Masukkan ID / Nama User"))
        {
            txtcariUs.setText("");
            txtcariUs.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtcariUsFocusGained

    private void txtcariUsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcariUsFocusLost
        // TODO add your handling code here:
                if (txtcariUs.getText().equals(""))
        {
            txtcariUs.setText("Masukkan ID / Nama User");
            txtcariUs.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtcariUsFocusLost

    private void txtcariUsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariUsKeyPressed
        // TODO add your handling code here:
           String sqlPencarian = "select * from tbluser where id_user like '%"+txtIDUser.getText()+"%' or nama_depan like '%"+txtNamaDepan.getText()+"%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_txtcariUsKeyPressed
=======
    private void txtCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariMouseClicked

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        // TODO add your handling code here:
        String sqlPencarian = "select * from tbluser where id_user like '%"+txtCari.getText()+"%' or nama_depan like '%"+txtCari.getText()+"%'";
        pencarian(sqlPencarian);
    }//GEN-LAST:event_txtCariKeyTyped

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        int bar = tabel.getSelectedRow();
        //String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 0).toString();
        txtIDUser.setText(b);
        txtIDUser.requestFocus();
    }//GEN-LAST:event_tabelMouseClicked

    private void txtIDUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDUserKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtNamaDepan.requestFocus();
        }
    }//GEN-LAST:event_txtIDUserKeyPressed

    private void txtNamaDepanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaDepanKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtNamaBelakang.requestFocus();
        }
    }//GEN-LAST:event_txtNamaDepanKeyPressed

    private void txtNamaBelakangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaBelakangKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtNoHp.requestFocus();
        }
    }//GEN-LAST:event_txtNamaBelakangKeyPressed

    private void txtNoHpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoHpKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtAlamat.requestFocus();
        }
    }//GEN-LAST:event_txtNoHpKeyPressed

    private void txtAlamatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlamatKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtLevel.requestFocus();
        }
    }//GEN-LAST:event_txtAlamatKeyPressed

    private void txtLevelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLevelKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtPassword.requestFocus();
        }
    }//GEN-LAST:event_txtLevelKeyPressed
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
            java.util.logging.Logger.getLogger(DataUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btUsrEdit;
    private javax.swing.JButton btnBackUser;
    private javax.swing.JButton btnBatal;
    private javax.swing.ButtonGroup btnGrp;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabel;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIDUser;
    private javax.swing.JTextField txtLevel;
    private javax.swing.JTextField txtNamaBelakang;
    private javax.swing.JTextField txtNamaDepan;
    private javax.swing.JTextField txtNoHp;
    private javax.swing.JTextField txtPassword;
<<<<<<< HEAD
    private javax.swing.JTextField txtcariUs;
=======
>>>>>>> 905fe7f79c50561bda536b0870c2ce2a700a442d
    // End of variables declaration//GEN-END:variables

    private void filterangka(KeyEvent a) {
          if (Character.isAlphabetic(a.getKeyChar())){
            a.consume();
            JOptionPane.showMessageDialog(null,"Hanya boleh diisi angka");
        }

    }

    private void filterhuruf(KeyEvent b) {
          if (Character.isDigit(b.getKeyChar())){
            b.consume();
            JOptionPane.showMessageDialog(null,"Hanya boleh diisi huruf");
          }
        
    }
}


