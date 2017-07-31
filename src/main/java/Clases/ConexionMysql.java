package Clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConexionMysql {

    private Connection con = null;
    private Operaciones op = new Operaciones();

    public Connection conexionmySQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemabancario", "root", "2603");
            System.out.println("conexion establecida");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error de conexion :( ");
            JOptionPane.showMessageDialog(null, "error de conexion " + e);
        }
        return con;
    }

    public String buscarUsuario(final String numero, final String pass) {
        String sql, tipo = "";
        final Connection reg = conexionmySQL();
        try {
            sql = "select nombre_usu FROM USUARIO "
                    + "WHERE cod_usuario='" + numero + "' AND clave = '" + pass + "'";
            final PreparedStatement pst = reg.prepareStatement(sql);
            final ResultSet resul = pst.executeQuery();
            while (resul.next()) {
                tipo = resul.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipo;
    }

    public String buscarCliente(final String cI) {
        final Connection reg = conexionmySQL();
        String sql;
        String ci;
        String nom;
        String ans = "No existe registro";
        try {

            sql = "select * FROM CLIENTE where cedula = '" + cI + "'";
            final PreparedStatement pst = reg.prepareStatement(sql);
            final ResultSet resul = pst.executeQuery();
            while (resul.next()) {
                ci = resul.getString(1);
                nom = resul.getString(2);
                ans = ci + " " + nom;
            }
        } catch (SQLException error) {
            System.out.println("Existe un ERROR: " + error);
        }
        return ans;
    }

    public void ingresoClientes(final String ci, final String nombre, final String apellido) {
        final Connection reg = conexionmySQL();
        try {
            //SELECCIONO LAS SENTENCIAS DE SQL--------------
            final PreparedStatement sentencia = reg.prepareStatement("INSERT INTO cliente VALUES (?,?)");
            sentencia.setString(2, nombre + " " + apellido);
            sentencia.setString(1, ci);
            //Este metodo actualiza y si afecta a mas de una columna se pone de 1 a mas
            final int res = sentencia.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "OK, DATOS GUARDADOS");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, DATOS FALLIDOS");
            }
        } catch (SQLException ex) {
            System.out.println("Algo Salio mal :(");
            Logger.getLogger(ConexionMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel cargarDatosCliente(final DefaultTableModel modeloCliente) {
        int cont1 = 1;
        final Connection reg = conexionmySQL();
        Object[] tcliente = new Object[3];
        try {
            final Statement sentenciaSQL = reg.createStatement();
            final ResultSet p = sentenciaSQL.executeQuery("select * from CLIENTE");
            while (p.next()) {
                tcliente[0] = cont1;
                tcliente[1] = p.getString("cedula");
                tcliente[2] = p.getString("nombre");
                modeloCliente.addRow(tcliente);
                cont1 = cont1 + 1;
            }
            System.out.println(":'v");
        } catch (SQLException error) {
            System.out.println("Existe un ERROR: " + error);
        }
        return modeloCliente;
    }

    public DefaultTableModel cargarDatosCuenta(final DefaultTableModel modeloCliente) {
        int cont1 = 1;
        final Connection reg = conexionmySQL();
        final Object[] tcliente = new Object[6];
        try {
            final Statement sentenciaSQL = reg.createStatement();
            final ResultSet p = sentenciaSQL.executeQuery("select * from CUENTA");
            while (p.next()) {
                tcliente[0] = cont1;
                tcliente[1] = p.getString("cod_cuenta");
                tcliente[2] = p.getString("cedula");
                tcliente[3] = p.getString("tipo");
                tcliente[4] = p.getString("saldo");
                tcliente[5] = p.getString("estado");
                modeloCliente.addRow(tcliente);
                cont1 = cont1 + 1;
            }
            System.out.println(":'v");
        } catch (SQLException error) {
            System.out.println("Existe un ERROR: " + error);
        }
        return modeloCliente;
    }

    public int eliminarCliente(final String codigo) {
        int val = 0;
        final Connection reg = conexionmySQL();
        try {
            final PreparedStatement sentencia = reg.prepareStatement("DELETE FROM CLIENTE WHERE cedula= ?");
            sentencia.setString(1, codigo);
            sentencia.execute();
            sentencia.close();
            System.out.println("Se ha eliminado: " + codigo);
            val = 1;
        } catch (SQLException error) {
            System.out.println("Existe un ERROR: " + error);
        }
        return val;
    }

    public int modificarCliente(final String cedula, final String nNombre) {
        int val = 0;
        final Connection reg = conexionmySQL();
        try {
            final PreparedStatement sentencia = reg.prepareStatement("UPDATE CLIENTE SET nombre= ? WHERE cedula= ?");
            sentencia.setString(1, nNombre);
            sentencia.setString(2, cedula);
            sentencia.execute();
            sentencia.close();
            System.out.println("Se ha modificado: " + cedula + " a: " + nNombre);
            val = 1;
        } catch (SQLException error) {
            System.out.println("Existe un ERROR: " + error);
        }
        return val;
    }

    public void ingresoMovimiento(final String codCuenta,
            final String tipo, final String fecha,
            final float monto, final float saldo) throws SQLException {
        int numRegistros = 0;
        int ultimoRegistro = 0;
        float nmonto = monto;
        if (tipo.equals("DEB")) {
            nmonto = nmonto * -1;
        }
        final Connection reg = conexionmySQL();
        final Statement sentenciaSQL = reg.createStatement();
        try {
            ResultSet p = sentenciaSQL.executeQuery("Select count(*) from Movimiento order by cod_movimiento");
            while (p.next()) {
                numRegistros = Integer.parseInt(p.getString("count(*)"));
            }
            if (numRegistros != 0) {
                p = sentenciaSQL.executeQuery("SELECT cod_movimiento "
                        + "FROM movimiento "
                        + "ORDER by cod_movimiento desc limit 1");
                while (p.next()) {
                    ultimoRegistro = p.getInt("cod_movimiento");
                }
            }
            if (ultimoRegistro == 0) {
                ultimoRegistro = 1000;
            }
            System.out.println("Ultimo regirtros = " + ultimoRegistro);
            //SELECCIONO LAS SENTENCIAS DE SQL--------------
            final float nsaldo = op.transaccion(saldo, nmonto);
            if (nsaldo != -1) {

                final PreparedStatement sentencia = reg.prepareStatement("INSERT INTO movimiento VALUES (?,?,?,?,?,?)");
                sentencia.setFloat(6, nsaldo);
                sentencia.setFloat(5, nmonto);
                sentencia.setString(4, fecha);
                sentencia.setString(3, tipo);
                sentencia.setString(2, codCuenta);
                sentencia.setInt(1, ultimoRegistro + 1);
                final int res = sentencia.executeUpdate();

                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "OK, DATOS GUARDADOS");
                    ActSaldo(codCuenta, nsaldo);
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR, DATOS FALLIDOS");
                }
            } else {
                JOptionPane.showConfirmDialog(null, "No dispone del saldo para realizar esta transaccion");
            }
        } catch (final SQLException ex) {
            System.out.println("Algo Salio mal");
            Logger.getLogger(ConexionMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel cargarDatosMovimiento(final DefaultTableModel modeloMovimiento) {
        final Connection reg = conexionmySQL();
        Object[] tmovimiento = new Object[5];
        try {
            final Statement sentenciaSQL = reg.createStatement();
            final ResultSet p = sentenciaSQL.executeQuery("select * from movimiento");
            while (p.next()) {
                tmovimiento[0] = p.getString("FECHA");
                tmovimiento[1] = p.getString("COD_MOVIMIENTO");
                tmovimiento[2] = p.getString("TIPO_MOV");
                tmovimiento[3] = p.getString("MONTO");
                tmovimiento[4] = p.getString("SALDO_MOV");
                modeloMovimiento.addRow(tmovimiento);
                //cont1 = cont1 + 1;
            }
            System.out.println(":'v");
        } catch (SQLException error) {
            System.out.println("Existe un ERROR: " + error);
        }
        return modeloMovimiento;
    }

    public String buscarCuenta(final String cuenta) {
        final Connection reg = conexionmySQL();
        final String sql1;
        String codCuenta;
        String ans = "No existe registro";
        try {
            sql1 = "select * FROM cuenta where COD_CUENTA = '" + cuenta + "'";
            final PreparedStatement pst1 = reg.prepareStatement(sql1);
            final ResultSet resul1 = pst1.executeQuery();

            while (resul1.next()) {
                codCuenta = resul1.getString(1);
                ans = codCuenta;
                System.out.println("Se recibio: " + codCuenta);
            }
        } catch (SQLException error) {
            System.out.println("Existe un ERROR: " + error);
        }
        return ans;
    }

    public String buscarMovimiento(final String cuenta) {
        final Connection reg = conexionmySQL();
        String sql1, codMov = "", codCuenta = "", tipoMov = "", fecha = "", monto = "", saldo = "";
        String ans = "No existe registro";
        try {

            sql1 = "select * FROM MOVIMIENTO where codigo = '" + cuenta;
            final PreparedStatement pst1 = reg.prepareStatement(sql1);
            final ResultSet resul1 = pst1.executeQuery();
            while (resul1.next()) {
                codMov = resul1.getString(1);
                codCuenta = resul1.getString(2);
                tipoMov = resul1.getString(3);
                fecha = resul1.getString(4);
                monto = resul1.getString(5);
                saldo = resul1.getString(6);
                ans = fecha + " " + "transaccion realizada" + " " + tipoMov + " " + monto + " " + saldo;
            }
        } catch (SQLException error) {
            System.out.println("Existe un ERROR: " + error);
        }
        return ans;
    }

    public float buscarSaldoCuenta(final String cuenta) {
        final Connection reg = conexionmySQL();
        float saldo = 0;
        try {
            final String sql1 = "select saldo FROM cuenta where COD_CUENTA = '" + cuenta + "'";
            final PreparedStatement pst1 = reg.prepareStatement(sql1);
            final ResultSet resul1 = pst1.executeQuery();
            while (resul1.next()) {
                saldo = resul1.getFloat(1);
                System.out.println("Se recibio: " + saldo);
            }
        } catch (SQLException error) {
            System.out.println("Existe un ERROR: " + error);
        }
        return saldo;
    }

    public void IngresoCuentas(final String cia,
            final String tipo,
            final Float saldo,
            final String estado) throws SQLException {
        int numRegistros = 0;
        int ultimoRegistro = 0;
        final Connection reg = conexionmySQL();
        final Statement sentenciaSQL;
        sentenciaSQL = con.createStatement();
        if (buscarCliente(cia).equals("No existe registro")) {
            JOptionPane.showMessageDialog(null, "ADVERTENCIA\nCedula encontrada o no existe:" + cia + "\nIngrese otra cedula o ingrese primero un cliente");
        } else {
            try {
                ResultSet p = sentenciaSQL.executeQuery("select count(*) from cuenta order by COD_CUENTA");
                while (p.next()) {
                    numRegistros = p.getInt("count(*)");
                }
                if (numRegistros != 0) {
                    p = sentenciaSQL.executeQuery("Select COD_CUENTA from cuenta order by COD_CUENTA+0 desc limit 1");
                    while (p.next()) {
                        ultimoRegistro = p.getInt("COD_CUENTA");
                    }
                }
                if (ultimoRegistro == 0) {
                    ultimoRegistro = 11111111;
                }
                System.out.println("Ultimo Registro: " + ultimoRegistro);
                final PreparedStatement sentencia = reg.prepareStatement("INSERT INTO cuenta VALUES (?,?,?,?,?)");
                sentencia.setString(5, estado);
                sentencia.setFloat(4, saldo);
                sentencia.setString(3, tipo);
                sentencia.setString(2, cia);
                sentencia.setInt(1, ultimoRegistro + 1);
                //Este metodo actualiza y si afecta a mas de una columna se pone de 1 a mas
                final int res = sentencia.executeUpdate();
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "OK, DATOS GUARDADOS");
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR, DATOS FALLIDOS");
                }

            } catch (SQLException ex) {
                System.out.println("Ultimo Registro: " + ultimoRegistro);
                System.out.println("Algo Salio mal :(");
                Logger.getLogger(ConexionMysql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList datos(final long cedula, final int tipo) throws SQLException {
        final ArrayList<Cuenta> info = new ArrayList<Cuenta>();
        final Statement sentenciaSQL;
        sentenciaSQL = con.createStatement();
        try {
            final ResultSet p = sentenciaSQL.executeQuery("select * from cuenta WHERE cedula= '" + cedula + "'  order by cedula");
            if (p.next() == false) {
            } else {
                do {
                    final Cuenta c = new Cuenta();
                    c.setCodigo(p.getInt("COD_CUENTA"));
                    c.setCi(p.getString("CEDULA"));
                    c.setTipo(p.getString("TIPO"));
                    c.setSaldo(p.getFloat("SALDO"));
                    c.setEstado(p.getString("ESTADO"));
                    info.add(c);
                } while (p.next());
            }
        } catch (SQLException error) {
            System.out.println("No existe esa info :'v" + error);
        }
        return info;
    }

    public ArrayList datos2(final long cedula, final int tipo) throws SQLException {
        final ArrayList<Cuenta> info2 = new ArrayList<Cuenta>();
        final Statement sentenciaSQL;
        sentenciaSQL = con.createStatement();
        try {
            final ResultSet p = sentenciaSQL.executeQuery("SELECT E.COD_CUENTA, C.NOMBRE, "
                    + "C.CEDULA, E.TIPO, E.SALDO, E.ESTADO FROM  CLIENTE C, Cuenta E"
                    + " WHERE C.CEDULA = '" + cedula + "' && E.CEDULA = '" + cedula + "'");
            if (!p.next()) {
                System.out.println("No hay perro :'v ");
            } else {
                do {
                    Cuenta c = new Cuenta();
                    c.setCodigo(p.getInt("COD_CUENTA"));
                    c.setCi(p.getString("CEDULA"));
                    c.setTipo(p.getString("TIPO"));
                    c.setSaldo(p.getFloat("SALDO"));
                    c.setEstado(p.getString("ESTADO"));
                    c.setNombre(p.getString("NOMBRE"));
                    info2.add(c);
                } while (p.next());
            }
        } catch (SQLException error) {
            System.out.println("No existe esa info :'v" + error);
        }
        return info2;
    }

    public ArrayList datos3(final String codCuenta, final int tipo) throws SQLException {
        final ArrayList<Cuenta> info = new ArrayList<Cuenta>();
        final Statement sentenciaSQL;
        sentenciaSQL = con.createStatement();
        try {
            final ResultSet p = sentenciaSQL.executeQuery("select * from cuenta WHERE cod_cuenta= '" + codCuenta + "'  order by cod_cuenta");
            if (p.next() == false) {
            } else {
                do {
                    Cuenta c = new Cuenta();
                    c.setCodigo(p.getInt("COD_CUENTA"));
                    c.setCi(p.getString("CEDULA"));
                    c.setTipo(p.getString("TIPO"));
                    c.setSaldo(p.getFloat("SALDO"));
                    c.setEstado(p.getString("ESTADO"));
                    info.add(c);
                } while (p.next());
            }
        } catch (SQLException error) {
            System.out.println("No existe esa info " + error);
        }
        return info;
    }

    public void cambiarcuenta(final String ced, final float saldo, final String estado) throws SQLException {

        Connection reg = conexionmySQL();
        final Statement sentenciaSQL;
        sentenciaSQL = con.createStatement();
        try {
            final PreparedStatement sentencia = reg.prepareStatement("UPDATE cuenta "
                    + "SET SALDO ='" + saldo + "' , ESTADO = '" + estado + "' "
                    + "WHERE CEDULA = '" + ced + "';");
            sentencia.execute();
            JOptionPane.showMessageDialog(null, "OK, DATOS GUARDADOS");
        } catch (SQLException ex) {
            System.out.println("Algo Salio mal :(");
            JOptionPane.showMessageDialog(null, "ERROR, DATOS FALLIDOS");
            Logger.getLogger(ConexionMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ActSaldo(final String cod_cuenta, final float nsaldo) {
        Connection reg = conexionmySQL();
        try {
            final PreparedStatement sentencia = reg.prepareStatement("UPDATE CUENTA SET saldo= ? WHERE cod_cuenta= ?");
            sentencia.setFloat(1, nsaldo);
            sentencia.setString(2, cod_cuenta);
            sentencia.execute();
            sentencia.close();
            System.out.println("Se ha modificado: el saldo");
        } catch (SQLException error) {
            System.out.println("Existe un ERROR: " + error);
        }
    }

    public ArrayList busmovimiento(final long cod_cuenta, final int tipo) throws SQLException {
        final ArrayList<Movimiento> ress = new ArrayList<Movimiento>();
        final Statement sentenciaSQL;
        sentenciaSQL = con.createStatement();
        try {
            final ResultSet p = sentenciaSQL.executeQuery("SELECT FECHA, COD_MOVIMIENTO, TIPO_MOV, MONTO, SALDO_MOV FROM movimiento where COD_CUENTA = '" + cod_cuenta + "' ORDER BY COD_MOVIMIENTO");
            if (p.next() == false) {
                JOptionPane.showMessageDialog(null, "El numero de cuenta no existe");
            } else {
                do {
                    Movimiento v = new Movimiento();
                    v.setFecha(p.getString("FECHA"));
                    v.setCodmovi(p.getInt("COD_MOVIMIENTO"));
                    v.setTipo(p.getString("TIPO_MOV"));
                    v.setMonto(p.getFloat("MONTO"));
                    v.setSaldo(p.getFloat("SALDO_MOV"));
                    ress.add(v);
                } while (p.next());
            }
        } catch (SQLException error) {
            System.out.println("No existe esa info :'v" + error);
        }
        return ress;
    }

    public ArrayList busmovimientoN(final int n) throws SQLException {
        final ArrayList<Movimiento> ress = new ArrayList<Movimiento>();
        final Statement sentenciaSQL;
        sentenciaSQL = con.createStatement();
        try {
            final ResultSet p = sentenciaSQL.executeQuery("SELECT FECHA, COD_MOVIMIENTO, TIPO_MOV, MONTO, SALDO_MOV FROM movimiento ORDER BY COD_MOVIMIENTO limit " + n);
            if (p.next() == false) {
                JOptionPane.showMessageDialog(null, "El numero de cuenta no existe");
            } else {
                do {
                    final Movimiento v = new Movimiento();
                    v.setFecha(p.getString("FECHA"));
                    v.setCodmovi(p.getInt("COD_MOVIMIENTO"));
                    v.setTipo(p.getString("TIPO_MOV"));
                    v.setMonto(p.getFloat("MONTO"));
                    v.setSaldo(p.getFloat("SALDO_MOV"));
                    ress.add(v);
                } while (p.next());
            }
        } catch (SQLException error) {
            System.out.println("No existe esa info " + error);
        }
        return ress;
    }

    public ArrayList busmovimientoPorN(final int cod_cuenta, final int n) throws SQLException {
        final ArrayList<Movimiento> ress = new ArrayList<Movimiento>();
        final Statement sentenciaSQL;
        sentenciaSQL = con.createStatement();
        try {
            final ResultSet p = sentenciaSQL.executeQuery("SELECT FECHA, COD_MOVIMIENTO, "
                    + "TIPO_MOV, MONTO, SALDO_MOV FROM movimiento where COD_CUENTA = '" + cod_cuenta + "' ORDER BY COD_MOVIMIENTO limit " + n);
            if (!p.next()) {
                JOptionPane.showMessageDialog(null, "El numero de cuenta no existe");
            } else {
                do {
                    final Movimiento v = new Movimiento();
                    v.setFecha(p.getString("FECHA"));
                    v.setCodmovi(p.getInt("COD_MOVIMIENTO"));
                    v.setTipo(p.getString("TIPO_MOV"));
                    v.setMonto(p.getFloat("MONTO"));
                    v.setSaldo(p.getFloat("SALDO_MOV"));
                    ress.add(v);
                } while (p.next());
            }
        } catch (SQLException error) {
            System.out.println("No existe esa info :'v" + error);
        }
        return ress;
    }

    public ArrayList busmovimientoTotal() throws SQLException {
        final ArrayList<Movimiento> ress = new ArrayList<Movimiento>();
        final Statement sentenciaSQL;
        sentenciaSQL = con.createStatement();
        try {
            final ResultSet p = sentenciaSQL.executeQuery("SELECT FECHA, COD_MOVIMIENTO, TIPO_MOV, MONTO, SALDO_MOV FROM movimiento ORDER BY COD_MOVIMIENTO+0");
            if (!p.next()) {
                System.out.println("ver aqui");
            } else {
                do {
                    final Movimiento v = new Movimiento();
                    v.setFecha(p.getString("FECHA"));
                    v.setCodmovi(p.getInt("COD_MOVIMIENTO"));
                    v.setTipo(p.getString("TIPO_MOV"));
                    v.setMonto(p.getFloat("MONTO"));
                    v.setSaldo(p.getFloat("SALDO_MOV"));
                    ress.add(v);
                } while (p.next());
            }
        } catch (SQLException error) {
            System.out.println("No existe esa info " + error);
        }
        return ress;
    }

}
