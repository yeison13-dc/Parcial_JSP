package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Banco;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Strings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BancoDAO  implements CRUD {

    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Banco ban=new Banco();


    @Override
    public List listar() {
        ArrayList<Banco>list=new ArrayList<>();
        String sql="select * from Banco";

        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Banco ban=new Banco();
                ban.setBan_id(rs.getString("ban_nit"));
                ban.setBan_nom(rs.getString("ban_nom"));
                list.add(ban);
            }

        }catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public Banco List(String codigo) {
        String sql=" select * from banco where ban_nit"+(String)codigo+"";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Banco ban=new Banco();
                ban.setBan_id(rs.getString("ban_nit"));
                ban.setBan_nom(rs.getString("ban_nom"));

            }

        }catch (Exception e) {
            System.out.println(e);
        }
        return ban;
    }

    @Override
    public boolean agregar(Banco ban) {
        String sql="insert into banco(ban_nit,ban_nom)values('"+ban.getBan_id()+"','"+ban.getBan_nom()+"');";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();


        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean actualizar(Banco ban) {
        String sql="update Banco set ban_nit='"+ban.getBan_id()+"',ban_nombre'"+ban.getBan_nom()+"'where ban_nit='"+ban.getBan_id()+"'";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();


        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean eliminar(String codigo) {
        String sql="delete from banco where ban_nit ="+codigo+"";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
