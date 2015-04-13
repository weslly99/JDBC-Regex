package br.com.weslly.exemple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.com.weslly.exemple.model.Contact;
import br.com.weslly.exemple.util.ConnectionFactory;

public class ContactDAO implements GenericDAO<Contact>{

	@Override
	public void add(Contact t) {
		
		Connection connection = ConnectionFactory.getConnection();
		String sql = "INSERT INTO contact (phone,email) VALUES (?,?)";
		
		//Usando o Try-With-Resource para fechar conexão
		try(PreparedStatement pst = 
				connection.prepareStatement(sql)){	
			pst.setString(1, t.getPhone());
			pst.setString(2,t.getEmail());
			pst.execute();
			System.out.println("Adicionado.");
			
		}catch(SQLException e){
			e.printStackTrace();
		}	
	}

	@Override
	public void update(Contact t) {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "UPDATE contact SET phone = ?,email = ? WHERE id = ?";
		
		//Usando o Try-With-Resource para fechar conexão
		try(PreparedStatement pst =
				connection.prepareStatement(sql)){
			pst.setString(1,t.getPhone());
			pst.setString(2,t.getEmail());
			pst.setLong(3,t.getId());
			pst.execute();
			System.out.println("Atualizado");
		}catch (Exception e) {
			e.getStackTrace();
		}	
	}

	@Override
	public void remove(long id) {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "DELETE FROM contact WHERE id= ?";
		try(PreparedStatement pst
				=connection.prepareStatement(sql)){
			pst.setLong(1,id);
			pst.execute();
			System.out.println("Deletado");
		}catch(SQLException e ){
			e.getStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Contact list(long id) {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM contact WHERE id = ?";
		Contact toReturn = null;
		
		try(PreparedStatement pst = 
				connection.prepareStatement(sql)){
			pst.setLong(1,id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				toReturn = populateContact(rs);
			}
			
		}catch(SQLException e){
			e.getStackTrace();
		}finally{
			try{
				if(!connection.isClosed()){
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return toReturn;
	}

	@Override
	public List<Contact> listAll() {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM contact";
		List<Contact> toReturn = new LinkedList();
		
		
		try(PreparedStatement pst = 
				connection.prepareStatement(sql)){
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){	
				toReturn.add(populateContact(rs));
			}
			rs.close();
		}catch(SQLException e){
			e.getStackTrace();
		}
		return toReturn;
	}

	private Contact populateContact(ResultSet rs) throws SQLException{	
		Contact contact = new Contact();
		contact.setId(rs.getLong("id"));
		contact.setPhone(rs.getString("phone"));
		contact.setEmail(rs.getString("email"));
		
		return contact;
	}

}
