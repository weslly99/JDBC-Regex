package br.com.weslly.exemple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.com.weslly.exemple.model.People;
import br.com.weslly.exemple.util.ConnectionFactory;

public class PeopleDAO implements GenericDAO<People> {

	@Override
	public void add(People t) {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "INSERT INTO people (name,lastname,cpf,rg,maritalStatus,gender,"
					+ "birth,contact_id,address_id) VALUES (?,?,?,?,?,?,?,?,?);";
		try{
			PreparedStatement pst = connection.prepareStatement(sql);
			pst = populatePreparedStatement(pst, t);
			pst.execute();
			pst.close();
			System.out.println("Pessoa Adicionada!");
			
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
	public void update(People t) {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "UPDATE people SET name=?,lastname=?,cpf=?,rg=?,maritalStatus=?"
				+ ",gender=?,birth=?,contact_id=?,address_id=? WHERE id=?";
	
		try{
			PreparedStatement pst = connection.prepareStatement(sql);
			pst = populatePreparedStatement(pst, t);
			pst.setLong(10,t.getId());
			pst.execute();
			pst.close();
			System.out.println("Pessoa Atualizada!");
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
	public void remove(long id) {
		Connection connection = ConnectionFactory.getConnection();
		String sql  = "DELETE FROM people WHERE id = ?";
		try{
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1,id);
			pst.execute();
			System.out.println("Pessoa Deletada!");
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
	public People list(long id) {
		Connection connection = ConnectionFactory.getConnection();
		String sql ="SELECT * FROM	people 	WHERE id= ?";
		People toReturn = new People();
		try{
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1,id);
			ResultSet rs = pst.executeQuery();
			rs.next();
			toReturn = populateResultSet(rs);
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
	public List<People> listAll() {
		Connection connection = ConnectionFactory.getConnection();
		String sql="SELECT * FROM people;";
		List<People> toReturn = new LinkedList();
		
		try{
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				toReturn.add(populateResultSet(rs));
			}
			
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

	private PreparedStatement populatePreparedStatement(PreparedStatement pst,People t)throws SQLException{
		
		pst.setString(1,t.getName());
		pst.setString(2,t.getLastName());
		pst.setString(3,t.getCPF());
		pst.setString(4,t.getRG());
		pst.setString(5,t.getMaritalStatus());
		pst.setString(6,String.valueOf(t.getGender()));
		//Utilizando o metodo statico ValueOf da class Java.SQL.Date para transformar LocalDate em Date
		pst.setDate(7,java.sql.Date.valueOf(t.getBirth()));
		pst.setLong(8,t.getContact().getId());
		pst.setLong(9,t.getAddress().getId());
		
		return pst;
	}

	private People populateResultSet(ResultSet rs) throws SQLException{
		AddressDAO addressDao = new AddressDAO();
		ContactDAO contactDao = new ContactDAO();
		People toReturn = new People();
		toReturn.setName(rs.getString("name"));
		toReturn.setLastName(rs.getString("lastName"));
		toReturn.setCPF(rs.getString("cpf"));
		toReturn.setRG(rs.getString("rg"));
		toReturn.setMaritalStatus(rs.getString("maritalStatus"));
		toReturn.setGender(rs.getString("gender").charAt(0));
		toReturn.setBirth(rs.getDate("birth").toLocalDate());
		toReturn.setAddress(addressDao.list(rs.getLong("address_id")));
		toReturn.setContact(contactDao.list(rs.getLong("contact_id")));
		
		
		return toReturn;
	}
}
