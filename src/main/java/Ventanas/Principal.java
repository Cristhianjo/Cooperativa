package Ventanas;

import Clases.ConexionMysql;
import Clases.Cuenta;
import Clases.Movimiento;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Clases.Operaciones;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhona
 */
public class Principal extends javax.swing.JFrame {

    private String fecha;
    private String hora;
    private String setCurrentUser;
    private final ConexionMysql con = new ConexionMysql();
    private final Operaciones op = new Operaciones();

    public Principal() {
        initComponents();
        cargarCliente();
        ValidacionTipeo();
        FechayHora();
    }

    public void reiniciarSistema() {
        cargarCliente();
        ValidacionTipeo();
        FechayHora();
        vaciarCuenta();
        vaciarMovimiento();
        gesCliTxBuscar.setText("");
        gesClitxCedula.setText("");
        gesClitxNombre.setText("");
        gesClitxApellido.setText("");
        txtbuscarmodiiii.setText("");
        jComboBox1.removeAllItems();
        txtcodigoblo.setText("");
        txtConsMovCuenta.setText("");
        txtnumCuenta.setText("");
        txtmontomovi.setText("");
        txtcicuentas1.setText("");
        txttipo.setText("");
        txtsaldoinicial1.setText("");

    }

    public void limpiarCuenta() {
        txtcicuentas.setText("");
        txtsaldoinicial.setText("");
    }

    public void FechayHora() {
        Calendar cal = Calendar.getInstance();
        int mes = cal.get(Calendar.MONTH) + 1;
        fecha = cal.get(Calendar.YEAR) + "-" + mes + "-" + cal.get(Calendar.DATE);
        hora = cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
        lblFecha.setText(fecha);

        lblHora.setText(hora);
        lblHora.hide();
        jLabel13.hide();
    }

    public void cargarCliente() {
        DefaultTableModel modeloCliente = (DefaultTableModel) c.getModel();
        c.setModel(con.cargarDatosCliente(modeloCliente));
        System.out.println("Se ha cargado cliente ");
    }

    public void cargarMovimientos() {
        DefaultTableModel modeloMovimiento = (DefaultTableModel) tablaMovimientosConsulta.getModel();
        tablaMovimientosConsulta.setModel(con.cargarDatosMovimiento(modeloMovimiento));
        System.out.println("Se ha cargado movimiento");
    }

    public void cargarCuenta() {
        DefaultTableModel modeloCuenta = (DefaultTableModel) Tabla_cuentas_consulta1.getModel();
        Tabla_cuentas_consulta1.setModel(con.cargarDatosCuenta(modeloCuenta));
        System.out.println("Se ha cargado cuenta ");
    }

    public void recargarCliente() {
        DefaultTableModel modelotc = (DefaultTableModel) c.getModel();
        int ntc = modelotc.getRowCount();
        for (int i = 0; i < ntc; i++) {
            modelotc.removeRow(0);
        }
        cargarCliente();
    }

    public void recargarCuenta() {
        DefaultTableModel modelotc = (DefaultTableModel) Tabla_cuentas_consulta1.getModel();
        int ntc = modelotc.getRowCount();
        for (int i = 0; i < ntc; i++) {
            modelotc.removeRow(0);
        }
        cargarCuenta();
    }

    public void recargarMovimiento() {
        DefaultTableModel modelotc = (DefaultTableModel) tablaMovimientosConsulta.getModel();
        int ntc = modelotc.getRowCount();
        for (int i = 0; i < ntc; i++) {
            modelotc.removeRow(0);
        }
    }

    public void vaciarCuenta() {
        DefaultTableModel modelotc = (DefaultTableModel) Tabla_cuentas_consulta1.getModel();
        int ntc = modelotc.getRowCount();
        for (int i = 0; i < ntc; i++) {
            modelotc.removeRow(0);
        }
    }

    public void vaciarMovimiento() {
        DefaultTableModel modelotc = (DefaultTableModel) tablaMovimientosConsulta.getModel();
        int ntc = modelotc.getRowCount();
        for (int i = 0; i < ntc; i++) {
            modelotc.removeRow(0);
        }
    }

    public void ValidacionTipeo() {
        gesClitxCedula.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent ke) {
                char c = ke.getKeyChar();
                if (Character.isLetter(c)) {
                    Toolkit.getDefaultToolkit().beep();
                    ke.consume();
                }
            }

            @Override
            public void keyPressed(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        gesClitxNombre.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent ke) {
                char c = ke.getKeyChar();
                if (Character.isDigit(c)) {
                    Toolkit.getDefaultToolkit().beep();
                    ke.consume();
                }
            }

            @Override
            public void keyPressed(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        gesClitxApellido.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent ke) {
                char c = ke.getKeyChar();
                if (Character.isDigit(c)) {
                    Toolkit.getDefaultToolkit().beep();
                    ke.consume();
                }
            }

            @Override
            public void keyPressed(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        txtmontomovi.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent ke) {
                char c = ke.getKeyChar();
                if (Character.isLetter(c)) {
                    Toolkit.getDefaultToolkit().beep();
                    ke.consume();
                }
            }

            @Override
            public void keyPressed(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        txtcicuentas.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    evt.consume();
                }
                if (txtcicuentas.getText().length() == 13) {
                    evt.consume();
                }
            }

            @Override
            public void keyPressed(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        gesCliTxBuscar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    evt.consume();
                }
                if (gesCliTxBuscar.getText().length() == 13) {
                    evt.consume();
                }
            }

            @Override
            public void keyPressed(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        txtsaldoinicial.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') && (caracter != '.')) {
                    evt.consume();
                }
                if (txtsaldoinicial.getText().contains(".") && (caracter == '.')) {
                    evt.consume();
                }
            }

            @Override
            public void keyPressed(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        txtbuscarmodiiii.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    evt.consume();
                }
                if (txtbuscarmodiiii.getText().length() == 13) {
                    evt.consume();
                }

            }

            @Override
            public void keyPressed(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        txtsaldoinicial1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') && (caracter != '.')) {
                    evt.consume();
                }
                if (txtsaldoinicial1.getText().contains(".") && (caracter == '.')) {
                    evt.consume();
                }
            }

            @Override
            public void keyPressed(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        txtbuscuenta2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    evt.consume();
                }
                if (txtbuscuenta2.getText().length() == 13) {
                    evt.consume();
                }
            }

            @Override
            public void keyPressed(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        txtnumCuenta.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    evt.consume();
                }
                if (txtnumCuenta.getText().length() == 13) {
                    evt.consume();
                }
            }

            @Override
            public void keyPressed(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        txtmontomovi.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') && (caracter != '.')) {
                    evt.consume();
                }
                if (txtmontomovi.getText().contains(".") && (caracter == '.')) {
                    evt.consume();
                }
                if (txtmontomovi.getText().length() == 13) {
                    evt.consume();
                }
            }

            @Override
            public void keyPressed(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        txtnumeroMov.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') && (caracter != '.')) {
                    evt.consume();
                }
                if (txtnumeroMov.getText().contains(".") && (caracter == '.')) {
                    evt.consume();
                }

            }

            @Override
            public void keyPressed(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        gesClitxCedula.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    evt.consume();
                }
                if (gesClitxCedula.getText().length() == 13) {
                    evt.consume();
                }
            }

            @Override
            public void keyPressed(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(final KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlRegMov = new javax.swing.JPanel();
        pnlRegMov2 = new javax.swing.JPanel();
        txtmontomovi = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cmbtipoMov = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtnumCuenta = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pnlGestClien = new javax.swing.JPanel();
        spnGesCl = new javax.swing.JTabbedPane();
        gesCliVisualizar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        c = new javax.swing.JTable();
        gesCliBtnBuscar = new javax.swing.JButton();
        gesCliTxBuscar = new javax.swing.JTextField();
        gesCliBtnEliminar = new javax.swing.JButton();
        gesCliBtnModificar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        gesCliIngreso = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        gesCliBtnGuardar = new javax.swing.JButton();
        gesClitxCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        gesClitxNombre = new javax.swing.JTextField();
        gesClitxApellido = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        pnlGesCuen = new javax.swing.JPanel();
        spnGesCl1 = new javax.swing.JTabbedPane();
        gesCliIngreso1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtcicuentas = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jcbtipocuenta = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        txtsaldoinicial = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cbestado = new javax.swing.JComboBox<>();
        gesCliBtnGuardar1 = new javax.swing.JButton();
        btnnuevocuenta = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        gesCliMod1 = new javax.swing.JPanel();
        btnbuscar = new javax.swing.JButton();
        txtbuscarmodiiii = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtcodigoblo = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtcicuentas1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txttipo = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtsaldoinicial1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        btnguardamodificado = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cbestado2 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnOk = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabla_cuentas_consulta1 = new javax.swing.JTable();
        txtbuscuenta2 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        btnConsultarCuentas1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        pnlConMov = new javax.swing.JPanel();
        lblConMovi = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMovimientosConsulta = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtnumeroMov = new javax.swing.JTextField();
        btnConsultasMovimientos = new javax.swing.JButton();
        txtConsMovCuenta = new javax.swing.JTextField();
        txDesde = new javax.swing.JTextField();
        txtHasta = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        fecha1 = new javax.swing.JLabel();
        lbUsuPrinc = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        princMItemCSesion = new javax.swing.JMenuItem();
        princMtemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel12.setText("Usuario: ");

        jTabbedPane1.setBackground(new java.awt.Color(240, 189, 172));

        txtmontomovi.setName("txtmonto_mov"); // NOI18N

        jLabel25.setText("Tipo: ");

        jLabel27.setText("Monto: ");

        cmbtipoMov.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Debito", "Credito" }));
        cmbtipoMov.setName("cmbtipoMov"); // NOI18N

        jButton1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jButton1.setText("Registrar");
        jButton1.setName("bntRegistroMov"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel26.setText("Numero de Cuenta: ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("$");

        jLabel34.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel34.setText("REGISTRO DE MOVIMIENTO");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos Pago.png"))); // NOI18N

        javax.swing.GroupLayout pnlRegMov2Layout = new javax.swing.GroupLayout(pnlRegMov2);
        pnlRegMov2.setLayout(pnlRegMov2Layout);
        pnlRegMov2Layout.setHorizontalGroup(
            pnlRegMov2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegMov2Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jLabel34)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlRegMov2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlRegMov2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRegMov2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegMov2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlRegMov2Layout.createSequentialGroup()
                        .addGroup(pnlRegMov2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRegMov2Layout.createSequentialGroup()
                                .addComponent(txtmontomovi, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbtipoMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addGap(136, 136, 136))))
        );
        pnlRegMov2Layout.setVerticalGroup(
            pnlRegMov2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegMov2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel34)
                .addGap(18, 18, 18)
                .addGroup(pnlRegMov2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegMov2Layout.createSequentialGroup()
                        .addGroup(pnlRegMov2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtnumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlRegMov2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbtipoMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(24, 24, 24)
                        .addGroup(pnlRegMov2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtmontomovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel23))
                .addGap(3, 3, 3)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlRegMovLayout = new javax.swing.GroupLayout(pnlRegMov);
        pnlRegMov.setLayout(pnlRegMovLayout);
        pnlRegMovLayout.setHorizontalGroup(
            pnlRegMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 749, Short.MAX_VALUE)
            .addGroup(pnlRegMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlRegMovLayout.createSequentialGroup()
                    .addGap(0, 14, Short.MAX_VALUE)
                    .addComponent(pnlRegMov2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 15, Short.MAX_VALUE)))
        );
        pnlRegMovLayout.setVerticalGroup(
            pnlRegMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
            .addGroup(pnlRegMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlRegMovLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlRegMov2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Registro de Movimientos", pnlRegMov);

        spnGesCl.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        c.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N", "C.I", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(c);
        if (c.getColumnModel().getColumnCount() > 0) {
            c.getColumnModel().getColumn(0).setResizable(false);
        }

        gesCliBtnBuscar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        gesCliBtnBuscar.setText("Buscar");
        gesCliBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gesCliBtnBuscarActionPerformed(evt);
            }
        });

        gesCliBtnEliminar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        gesCliBtnEliminar.setText("Eliminar");
        gesCliBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gesCliBtnEliminarActionPerformed(evt);
            }
        });

        gesCliBtnModificar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        gesCliBtnModificar.setText("Modificar");
        gesCliBtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gesCliBtnModificarActionPerformed(evt);
            }
        });

        jLabel10.setText("Ingrese N.- Cedula: ");

        javax.swing.GroupLayout gesCliVisualizarLayout = new javax.swing.GroupLayout(gesCliVisualizar);
        gesCliVisualizar.setLayout(gesCliVisualizarLayout);
        gesCliVisualizarLayout.setHorizontalGroup(
            gesCliVisualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gesCliVisualizarLayout.createSequentialGroup()
                .addGroup(gesCliVisualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gesCliVisualizarLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(gesCliBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(gesCliBtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gesCliVisualizarLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gesCliTxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(gesCliBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gesCliVisualizarLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        gesCliVisualizarLayout.setVerticalGroup(
            gesCliVisualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gesCliVisualizarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gesCliVisualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(gesCliTxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gesCliBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(gesCliVisualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gesCliBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gesCliBtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spnGesCl.addTab("Visualizar", gesCliVisualizar);

        jLabel1.setText("Cedula: ");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        gesCliBtnGuardar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        gesCliBtnGuardar.setText("Guardar");
        gesCliBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gesCliBtnGuardarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel4.setText("INGRESO DE CLIENTES");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/folder_customer_256.png"))); // NOI18N

        javax.swing.GroupLayout gesCliIngresoLayout = new javax.swing.GroupLayout(gesCliIngreso);
        gesCliIngreso.setLayout(gesCliIngresoLayout);
        gesCliIngresoLayout.setHorizontalGroup(
            gesCliIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gesCliIngresoLayout.createSequentialGroup()
                .addGroup(gesCliIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gesCliIngresoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(gesCliIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(gesCliIngresoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gesClitxNombre))
                            .addGroup(gesCliIngresoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gesClitxCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gesCliIngresoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gesClitxApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(gesCliIngresoLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(gesCliBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(104, 104, 104))
            .addGroup(gesCliIngresoLayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gesCliIngresoLayout.setVerticalGroup(
            gesCliIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gesCliIngresoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addGroup(gesCliIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(gesClitxCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gesCliIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gesCliIngresoLayout.createSequentialGroup()
                        .addGroup(gesCliIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(gesClitxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(gesCliIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gesClitxApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(60, 60, 60)
                        .addComponent(gesCliBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        spnGesCl.addTab("Ingreso", gesCliIngreso);

        javax.swing.GroupLayout pnlGestClienLayout = new javax.swing.GroupLayout(pnlGestClien);
        pnlGestClien.setLayout(pnlGestClienLayout);
        pnlGestClienLayout.setHorizontalGroup(
            pnlGestClienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spnGesCl)
        );
        pnlGestClienLayout.setVerticalGroup(
            pnlGestClienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGestClienLayout.createSequentialGroup()
                .addComponent(spnGesCl, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gestion de Clientes", pnlGestClien);

        spnGesCl1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel18.setText("Cedula:");

        jLabel19.setText("Tipo:");

        jcbtipocuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AHO", "COR" }));

        jLabel21.setText("Saldo:");

        jLabel22.setText("Estado:");

        cbestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACT", "INA" }));

        gesCliBtnGuardar1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        gesCliBtnGuardar1.setText("Guardar");
        gesCliBtnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gesCliBtnGuardar1ActionPerformed(evt);
            }
        });

        btnnuevocuenta.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnnuevocuenta.setText("Nuevo");
        btnnuevocuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevocuentaActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel28.setText("REGISTRO DE CUENTA");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/movi.png"))); // NOI18N

        javax.swing.GroupLayout gesCliIngreso1Layout = new javax.swing.GroupLayout(gesCliIngreso1);
        gesCliIngreso1.setLayout(gesCliIngreso1Layout);
        gesCliIngreso1Layout.setHorizontalGroup(
            gesCliIngreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gesCliIngreso1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(gesCliIngreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gesCliIngreso1Layout.createSequentialGroup()
                        .addGroup(gesCliIngreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(gesCliIngreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbtipocuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcicuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(gesCliIngreso1Layout.createSequentialGroup()
                        .addGroup(gesCliIngreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(gesCliIngreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsaldoinicial, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(79, 79, 79))
            .addGroup(gesCliIngreso1Layout.createSequentialGroup()
                .addGroup(gesCliIngreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gesCliIngreso1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(gesCliBtnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnnuevocuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gesCliIngreso1Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel28)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gesCliIngreso1Layout.setVerticalGroup(
            gesCliIngreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gesCliIngreso1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addGroup(gesCliIngreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(gesCliIngreso1Layout.createSequentialGroup()
                        .addGroup(gesCliIngreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcicuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(gesCliIngreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jcbtipocuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(gesCliIngreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(txtsaldoinicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(gesCliIngreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel20))
                .addGap(46, 46, 46)
                .addGroup(gesCliIngreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gesCliBtnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnuevocuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        spnGesCl1.addTab("Crear", gesCliIngreso1);

        btnbuscar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jLabel15.setText("Codigo:");

        jLabel29.setText("Cedula:");

        jLabel30.setText("Tipo:");

        jLabel31.setText("Saldo:");

        txtsaldoinicial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsaldoinicial1ActionPerformed(evt);
            }
        });

        jLabel32.setText("Estado:");

        btnguardamodificado.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnguardamodificado.setText("Guardar Cambios");
        btnguardamodificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardamodificadoActionPerformed(evt);
            }
        });

        jLabel16.setText("Ingrese N.- Cedula: ");

        jLabel17.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel17.setText("Modificar una Cuenta");

        jLabel24.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel24.setText("Cambiar Saldo o Desactivar una cuenta ");

        cbestado2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACT", "INA" }));

        jLabel37.setText("Cuenta:");

        btnOk.setText("ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gesCliMod1Layout = new javax.swing.GroupLayout(gesCliMod1);
        gesCliMod1.setLayout(gesCliMod1Layout);
        gesCliMod1Layout.setHorizontalGroup(
            gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gesCliMod1Layout.createSequentialGroup()
                .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gesCliMod1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel24))
                    .addGroup(gesCliMod1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(btnguardamodificado, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(gesCliMod1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gesCliMod1Layout.createSequentialGroup()
                        .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gesCliMod1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcodigoblo))
                            .addGroup(gesCliMod1Layout.createSequentialGroup()
                                .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel32))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtsaldoinicial1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(gesCliMod1Layout.createSequentialGroup()
                                        .addComponent(cbestado2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 157, Short.MAX_VALUE))
                                    .addComponent(txtcicuentas1)
                                    .addComponent(txttipo, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(316, 316, 316))
                    .addGroup(gesCliMod1Layout.createSequentialGroup()
                        .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(gesCliMod1Layout.createSequentialGroup()
                                .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtbuscarmodiiii, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        gesCliMod1Layout.setVerticalGroup(
            gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gesCliMod1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscarmodiiii, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(btnbuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(btnOk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtcodigoblo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtcicuentas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txttipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtsaldoinicial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gesCliMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(cbestado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(btnguardamodificado, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spnGesCl1.addTab("Modificar", gesCliMod1);

        Tabla_cuentas_consulta1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N", "Numero de Cuenta", "CI Cliente", "Tipo", "Saldo", "Estado"
            }
        ));
        jScrollPane4.setViewportView(Tabla_cuentas_consulta1);

        jLabel35.setText("Ingrese N.- Cedula: ");

        btnConsultarCuentas1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnConsultarCuentas1.setText("Consultar");
        btnConsultarCuentas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarCuentas1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ver Todos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel33.setText("Cliente: ");

        jLabel36.setText("-----------");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jButton2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel36))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtbuscuenta2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(btnConsultarCuentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscuenta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(btnConsultarCuentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel36))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        spnGesCl1.addTab("Ver ", jPanel3);

        javax.swing.GroupLayout pnlGesCuenLayout = new javax.swing.GroupLayout(pnlGesCuen);
        pnlGesCuen.setLayout(pnlGesCuenLayout);
        pnlGesCuenLayout.setHorizontalGroup(
            pnlGesCuenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spnGesCl1)
        );
        pnlGesCuenLayout.setVerticalGroup(
            pnlGesCuenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGesCuenLayout.createSequentialGroup()
                .addComponent(spnGesCl1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gestion Cuentas", pnlGesCuen);

        lblConMovi.setText("Cuenta ");

        tablaMovimientosConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Concepto", "Tipo", "Monto", "Saldo"
            }
        ));
        jScrollPane2.setViewportView(tablaMovimientosConsulta);

        jLabel5.setText("Busqueda por Fechas:");

        jLabel6.setText("De:");

        jLabel7.setText("Hasta:");

        jLabel8.setText("Busqueda por los ultimos movimientos:");

        jLabel9.setText("Numeros de Movimientos:");

        txtnumeroMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroMovActionPerformed(evt);
            }
        });

        btnConsultasMovimientos.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnConsultasMovimientos.setText("Consultar");
        btnConsultasMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasMovimientosActionPerformed(evt);
            }
        });

        jLabel38.setText("Si esta vacio, buscara todos los registros");

        javax.swing.GroupLayout pnlConMovLayout = new javax.swing.GroupLayout(pnlConMov);
        pnlConMov.setLayout(pnlConMovLayout);
        pnlConMovLayout.setHorizontalGroup(
            pnlConMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConMovLayout.createSequentialGroup()
                .addGroup(pnlConMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConMovLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(pnlConMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlConMovLayout.createSequentialGroup()
                                .addGroup(pnlConMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(pnlConMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlConMovLayout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlConMovLayout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(71, 71, 71)
                                .addGroup(pnlConMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(pnlConMovLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtnumeroMov, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlConMovLayout.createSequentialGroup()
                                .addComponent(lblConMovi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtConsMovCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel38))))
                    .addGroup(pnlConMovLayout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(btnConsultasMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlConMovLayout.setVerticalGroup(
            pnlConMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConMovLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlConMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConMovi)
                    .addComponent(txtConsMovCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(18, 18, 18)
                .addGroup(pnlConMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConMovLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlConMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlConMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlConMovLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlConMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtnumeroMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultasMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta Movimientos", pnlConMov);

        fecha1.setText("Fecha: ");

        lbUsuPrinc.setText("usu");

        lblFecha.setText("--/--/----");

        jLabel13.setText("Hora: ");

        lblHora.setText("--:--");

        jMenu1.setText("Archivo");

        princMItemCSesion.setText("Cerrar Sesion");
        princMItemCSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                princMItemCSesionActionPerformed(evt);
            }
        });
        jMenu1.add(princMItemCSesion);

        princMtemSalir.setText("Salir");
        princMtemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                princMtemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(princMtemSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem2.setText("Reinciar Sistema");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ayuda");

        jMenuItem1.setText("Acerca de");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUsuPrinc)
                .addGap(68, 68, 68)
                .addComponent(fecha1)
                .addGap(18, 18, 18)
                .addComponent(lblFecha)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHora)
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(fecha1)
                    .addComponent(lbUsuPrinc)
                    .addComponent(lblFecha)
                    .addComponent(jLabel13)
                    .addComponent(lblHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void princMtemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_princMtemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_princMtemSalirActionPerformed

    private void princMItemCSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_princMItemCSesionActionPerformed
        Loggin l = new Loggin();
        l.show();
        this.hide();
    }//GEN-LAST:event_princMItemCSesionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JOptionPane.showMessageDialog(null, "Sistema Bancario Version 1\n\nCreado por: \nJhonathan Lechon \n Victoria Espinosa \n Solange Pico", "Autores", 1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnConsultasMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasMovimientosActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablaMovimientosConsulta.getModel();
        ArrayList<Movimiento> moviss = new ArrayList<Movimiento>();
        String i = "";
        if (txtConsMovCuenta.getText().equals("") && txDesde.getText().equals("") && txtHasta.getText().equals("") && txtnumeroMov.getText().equals("")) {
            try {
                vaciarMovimiento();
                moviss = con.busmovimientoTotal();
                for (Movimiento m : moviss) {
                    Object[] fila = new Object[5];
                    fila[0] = m.getFecha();
                    fila[1] = m.getCodmovi();
                    fila[2] = m.getTipo();
                    fila[3] = m.getMonto();
                    fila[4] = m.getSaldo();
                    model.addRow(fila);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            if (txtnumeroMov.getText().equals("") && txtConsMovCuenta.getText().equals("") && !txDesde.getText().equals("") && !txtHasta.getText().equals("")) {
                try {
                    if (op.validarRangoFechas(txDesde.getText(), txtHasta.getText(), fecha).equals("1")) {
                        System.out.println("Funciona");
                    } else {
                        System.out.println("No vale");
                    }

                } catch (ParseException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (!txtnumeroMov.getText().equals("") && txtConsMovCuenta.getText().equals("") && txDesde.getText().equals("") && txtHasta.getText().equals("")) {
                try {
                    moviss = con.busmovimientoN(Integer.parseInt(txtnumeroMov.getText()));
                    vaciarMovimiento();
                    for (Movimiento m : moviss) {
                        Object[] fila = new Object[5];
                        fila[0] = m.getFecha();
                        fila[1] = m.getCodmovi();
                        fila[2] = m.getTipo();
                        fila[3] = m.getMonto();
                        fila[4] = m.getSaldo();
                        model.addRow(fila);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (txtnumeroMov.getText().equals("") && !txtConsMovCuenta.getText().equals("") && txDesde.getText().equals("") && txtHasta.getText().equals("")) {
                    try {
                        moviss = con.busmovimiento(Integer.parseInt(txtConsMovCuenta.getText()), 2);
                        vaciarMovimiento();
                        for (Movimiento m : moviss) {
                            Object[] fila = new Object[5];
                            fila[0] = m.getFecha();
                            fila[1] = m.getCodmovi();
                            fila[2] = m.getTipo();
                            fila[3] = m.getMonto();
                            fila[4] = m.getSaldo();
                            model.addRow(fila);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (!txtConsMovCuenta.getText().equals("") && !txtnumeroMov.getText().equals("") && txDesde.getText().equals("") && txtHasta.getText().equals("")) {
                        try {
                            moviss = con.busmovimientoPorN(Integer.parseInt(txtConsMovCuenta.getText()), Integer.parseInt(txtnumeroMov.getText()));
                            vaciarMovimiento();
                            for (Movimiento m : moviss) {
                                Object[] fila = new Object[5];
                                fila[0] = m.getFecha();
                                fila[1] = m.getCodmovi();
                                fila[2] = m.getTipo();
                                fila[3] = m.getMonto();
                                fila[4] = m.getSaldo();
                                model.addRow(fila);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnConsultasMovimientosActionPerformed

    private void txtnumeroMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroMovActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroMovActionPerformed

    private void btnConsultarCuentas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarCuentas1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) Tabla_cuentas_consulta1.getModel();
        ArrayList<Cuenta> data = new ArrayList<Cuenta>();
        String i = "";
        if (txtbuscuenta2.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Ingresa un valor");
        } else {
            vaciarCuenta();
            if (con.buscarCliente(txtbuscuenta2.getText()).equals("No existe registro")) {
                JOptionPane.showMessageDialog(rootPane, "No se encontro Cedula o Ruc");
            } else {
                try {
                    data = con.datos2(Long.parseLong(txtbuscuenta2.getText()), 2);
                    for (Cuenta c : data) {
                        Object[] fila = new Object[6];
                        fila[0] = 1;
                        fila[1] = c.getCodigo();
                        fila[2] = c.getCi();
                        fila[3] = c.getTipo();
                        fila[4] = c.getSaldo();
                        fila[5] = c.getEstado();
                        model.addRow(fila);
                        jLabel36.setText(c.getNombre());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnConsultarCuentas1ActionPerformed

    private void btnguardamodificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardamodificadoActionPerformed
        // TODO add your handling code here:
        if (txtsaldoinicial1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Uno o mas campos vacios");
        } else if (Float.parseFloat(txtsaldoinicial1.getText()) >= 0) {
            try {
                con.cambiarcuenta((txtcicuentas1.getText()), Float.parseFloat(txtsaldoinicial1.getText()), cbestado2.getSelectedItem().toString());
                recargarCuenta();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Saldo no valido");
        }
    }//GEN-LAST:event_btnguardamodificadoActionPerformed

    private void txtsaldoinicial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsaldoinicial1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsaldoinicial1ActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        //DefaultTableModel model = (DefaultTableModel) tablaCuentaModi.getModel();
        ArrayList<Cuenta> data = new ArrayList<Cuenta>();
        String i = "";
        if (txtbuscarmodiiii.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Ingresa un valor");
        } else {
            long integer = 2;
            jComboBox1.removeAllItems();
            try {
                integer = Long.parseLong(txtbuscarmodiiii.getText());
                data = con.datos(Long.parseLong(txtbuscarmodiiii.getText()), 2);
                for (Cuenta c : data) {
                    jComboBox1.addItem(String.valueOf(c.getCodigo()));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con.buscarCliente(txtbuscarmodiiii.getText()).equals("No existe registro")) {
            JOptionPane.showMessageDialog(rootPane, "No se encontro Cedula o Ruc");
        } else {
            jComboBox1.removeAllItems();
            try {
                data = con.datos(Long.parseLong(txtbuscarmodiiii.getText()), 2);
                for (Cuenta c : data) {
                    jComboBox1.addItem(String.valueOf(c.getCodigo()));
                    //                    txtcicuentas1.setText(c.getCi());
                    //                    txttipo.setText(c.getTipo());
                    //                    txtsaldoinicial1.setText(String.valueOf(c.getSaldo()));
                    //                    cbestado2.(c.getEstado());
                }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        txtcodigoblo.setEditable(false);
        txtcicuentas1.setEditable(false);
        txttipo.setEditable(false);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnnuevocuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevocuentaActionPerformed
        // TODO add your handling code here:
        limpiarCuenta();
    }//GEN-LAST:event_btnnuevocuentaActionPerformed

    private void gesCliBtnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gesCliBtnGuardar1ActionPerformed
        if (txtcicuentas.getText().isEmpty() || txtsaldoinicial.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Uno o mas campos vacios ");
        } else {
            try {

                con.IngresoCuentas(txtcicuentas.getText(), jcbtipocuenta.getSelectedItem().toString(), Float.parseFloat(txtsaldoinicial.getText()), cbestado.getSelectedItem().toString());
                recargarCuenta();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gesCliBtnGuardar1ActionPerformed

    private void gesCliBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gesCliBtnGuardarActionPerformed
        if (gesClitxCedula.getText().equals("") || gesClitxNombre.getText().equals("") || gesClitxApellido.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Uno o mas campos vacios");
        } else if (op.validadorDeCedula(gesClitxCedula.getText())) {
            String respuesta = con.buscarCliente(gesClitxCedula.getText());
            System.out.println("Respuesta: " + respuesta);
            if (respuesta.equals("No existe registro")) {
                con.ingresoClientes(gesClitxCedula.getText(), gesClitxNombre.getText(), gesClitxApellido.getText());
                recargarCliente();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Usuario ya Existente");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "CI Incorrecta");
        }

    }//GEN-LAST:event_gesCliBtnGuardarActionPerformed

    private void gesCliBtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gesCliBtnModificarActionPerformed
        DefaultTableModel model = (DefaultTableModel) c.getModel();
        int a = c.getSelectedRow();

        if (a < 0) {

            JOptionPane.showMessageDialog(null,
                    "Debe seleccionar una fila de la tabla");

        } else {
            String nNombre = JOptionPane.showInputDialog(null, "Ingrese nuevo nombre: ", "Modificacion Nombre", 1);
            if (nNombre.equals("")) {
                JOptionPane.showMessageDialog(null, "Registro No modificado");
            } else if (con.modificarCliente("" + model.getValueAt(a, 1), nNombre) == 1) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Registro No modificado");
            }
            recargarCliente();
        }
    }//GEN-LAST:event_gesCliBtnModificarActionPerformed

    private void gesCliBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gesCliBtnEliminarActionPerformed
        DefaultTableModel model = (DefaultTableModel) c.getModel();
        int a = c.getSelectedRow();

        if (a < 0) {

            JOptionPane.showMessageDialog(null,
                    "Debe seleccionar una fila de la tabla");

        } else {
            int confirmar = JOptionPane.showConfirmDialog(null,
                    "Esta seguro que desea Eliminar el registro? ");
            if (JOptionPane.OK_OPTION == confirmar) {
                if (con.eliminarCliente("" + model.getValueAt(a, 1)) == 1) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Registro No se puede eliminar");
                }
                recargarCliente();
            }
        }
    }//GEN-LAST:event_gesCliBtnEliminarActionPerformed

    private void gesCliBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gesCliBtnBuscarActionPerformed
        if (gesCliTxBuscar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pon algo para buscar    :'v ");
        } else {
            JOptionPane.showMessageDialog(null, con.buscarCliente(gesCliTxBuscar.getText()));
        }
    }//GEN-LAST:event_gesCliBtnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String t = "";
        if (cmbtipoMov.getSelectedItem().equals("Debito")) {
            t = "DEB";
        } else {
            t = "CRE";
        }
        String monto = txtmontomovi.getText();
        float mon = Float.parseFloat(monto);
        if (txtnumCuenta.getText().equals("") || cmbtipoMov.getSelectedItem().equals("") || txtmontomovi.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Uno o mas campos vacios");
        } else {
            if (mon > 0) {
                String respuesta = con.buscarCuenta(txtnumCuenta.getText());
                System.out.println("Respuesta: " + respuesta);
                if (respuesta.equals(txtnumCuenta.getText())) {
                    try {
                        con.ingresoMovimiento(txtnumCuenta.getText(), t, fecha + " " + hora, mon, con.buscarSaldoCuenta(txtnumCuenta.getText()));
                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    recargarMovimiento();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "La cuenta no existe");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "El valor debe ser mayor a cero");
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jLabel36.setText("");
        vaciarCuenta();
        cargarCuenta();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        //DefaultTableModel model = (DefaultTableModel) tablaCuentaModi.getModel();
        ArrayList<Cuenta> data = new ArrayList<Cuenta>();
        String i = "";
        if (txtbuscarmodiiii.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Ingresa un valor");
        } else {
            try {
                data = con.datos3(jComboBox1.getSelectedItem().toString(), 2);
                for (Cuenta c : data) {
                    txtcodigoblo.setText(String.valueOf(c.getCodigo()));
                    txtcicuentas1.setText(c.getCi());
                    txttipo.setText(c.getTipo());
                    txtsaldoinicial1.setText(String.valueOf(c.getSaldo()));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        txtcodigoblo.setEditable(false);
        txtcicuentas1.setEditable(false);
        txttipo.setEditable(false);
    }//GEN-LAST:event_btnOkActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        reiniciarSistema();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_cuentas_consulta1;
    private javax.swing.JButton btnConsultarCuentas1;
    private javax.swing.JButton btnConsultasMovimientos;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnguardamodificado;
    private javax.swing.JButton btnnuevocuenta;
    public javax.swing.JTable c;
    private javax.swing.JComboBox<String> cbestado;
    private javax.swing.JComboBox<String> cbestado2;
    private javax.swing.JComboBox<String> cmbtipoMov;
    private javax.swing.JLabel fecha1;
    private javax.swing.JButton gesCliBtnBuscar;
    private javax.swing.JButton gesCliBtnEliminar;
    private javax.swing.JButton gesCliBtnGuardar;
    private javax.swing.JButton gesCliBtnGuardar1;
    private javax.swing.JButton gesCliBtnModificar;
    private javax.swing.JPanel gesCliIngreso;
    private javax.swing.JPanel gesCliIngreso1;
    private javax.swing.JPanel gesCliMod1;
    private javax.swing.JTextField gesCliTxBuscar;
    private javax.swing.JPanel gesCliVisualizar;
    private javax.swing.JTextField gesClitxApellido;
    private javax.swing.JTextField gesClitxCedula;
    private javax.swing.JTextField gesClitxNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcbtipocuenta;
    public javax.swing.JLabel lbUsuPrinc;
    private javax.swing.JLabel lblConMovi;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JPanel pnlConMov;
    private javax.swing.JPanel pnlGesCuen;
    private javax.swing.JPanel pnlGestClien;
    private javax.swing.JPanel pnlRegMov;
    private javax.swing.JPanel pnlRegMov2;
    private javax.swing.JMenuItem princMItemCSesion;
    private javax.swing.JMenuItem princMtemSalir;
    private javax.swing.JTabbedPane spnGesCl;
    private javax.swing.JTabbedPane spnGesCl1;
    private javax.swing.JTable tablaMovimientosConsulta;
    private javax.swing.JTextField txDesde;
    private javax.swing.JTextField txtConsMovCuenta;
    private javax.swing.JTextField txtHasta;
    private javax.swing.JTextField txtbuscarmodiiii;
    private javax.swing.JTextField txtbuscuenta2;
    private javax.swing.JTextField txtcicuentas;
    private javax.swing.JTextField txtcicuentas1;
    private javax.swing.JTextField txtcodigoblo;
    private javax.swing.JTextField txtmontomovi;
    private javax.swing.JTextField txtnumCuenta;
    private javax.swing.JTextField txtnumeroMov;
    private javax.swing.JTextField txtsaldoinicial;
    private javax.swing.JTextField txtsaldoinicial1;
    private javax.swing.JTextField txttipo;
    // End of variables declaration//GEN-END:variables

    public String getSetCurrentUser() {
        return setCurrentUser;
    }

    public void setSetCurrentUser(String setCurrentUser) {
        this.setCurrentUser = setCurrentUser;
    }
}
