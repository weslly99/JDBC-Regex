package br.com.weslly.exemple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.com.weslly.exemple.model.Address;
import br.com.weslly.exemple.util.ConnectionFactory;

public class AddressDAO implements GenericDAO<Address> {

	@Override
	public void add(Address t) {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "INSERT INTO address (uf,city,district,street,number) VALUES(?,?,?,?,?);";
		try{
			PreparedStatement pst  = connection.prepareStatement(sql);
			pst = populatePreparedStatement(t, pst);
			
			pst.execute();
			pst.close();
		System.out.println("Endereço adicionado!");	
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(!connection.isClosed()){
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Address t) {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "UPDATE address SET uf=?,city=?,district=?,street=?,number=? WHERE id=?";
		
		try{
			PreparedStatement pst = connection.prepareStatement(sql);
			pst = populatePreparedStatement(t, pst);
			pst.setLong(6,t.getId());
			
			pst.execute();
			pst.close();
			System.out.println("Endereço Atualizado!");	
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			try{
				if(!connection.isClosed()){
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
			
	}

	@Override
	public void remove(long id) {
		Connection connection  = ConnectionFactory.getConnection();
		String sql = "DELETE * FROM address WHERE id=?";
		try{
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1,id);
			pst.execute();
			pst.close();
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(!connection.isClosed()){
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public Address list(long id) {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM address WHERE id=?";
		Address toReturn = new Address();
		try{
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1,id);
			ResultSet rs = pst.executeQuery();
			rs.next();
			toReturn = populateResultSet(rs);
			rs.close();
			pst.close();
		}catch(SQLException e){
			e.printStackTrace();	
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
	public List<Address> listAll() {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM address";
		List<Address> toReturn = new LinkedList();
		try{
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				toReturn.add(populateResultSet(rs));
			}
			rs.close();
			pst.close();
		}catch(SQLException e){
			e.printStackTrace();
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
	
	private PreparedStatement populatePreparedStatement(Address t, PreparedStatement pst) throws SQLException{	
		pst.setString(1,t.getUF());
		pst.setString(2,t.getCity());
		pst.setString(3,t.getDistrict());
		pst.setString(4,t.getStreet());
		pst.setString(5,t.getNumber());
		
		return pst;
	}
	
	private Address populateResultSet(ResultSet rs)throws SQLException{
		Address toReturn = new Address();
		
		toReturn.setId(rs.getLong("id"));
		toReturn.setUF(rs.getString("uf"));
		toReturn.setCity(rs.getString("city"));
		toReturn.setDistrict(rs.getString("district"));
		toReturn.setStreet(rs.getString("street"));
		toReturn.setNumber(rs.getString("number"));
		
		return toReturn;
	}
	
}
