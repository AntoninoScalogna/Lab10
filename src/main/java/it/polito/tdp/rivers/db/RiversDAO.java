package it.polito.tdp.rivers.db;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.River;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class RiversDAO {

	public void getAllRivers(Map<Integer, River> m) {
		
		final String sql = "SELECT id, name FROM river";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				m.put(res.getInt("id"),new River(res.getInt("id"), res.getString("name")));
			}

			conn.close();
			st.close();
			res.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return;
	}
	public LinkedList<Flow> getAllFlows(Integer river) {
		LinkedList<Flow> result=new LinkedList<Flow>();
		String sql="SELECT day,flow,flow.id AS fid, river.id AS rid,name "
				+ "FROM flow,river "
				+ "WHERE river.id=? AND flow.river=river.id ";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, river);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				result.add(new Flow(res.getInt("fid"), res.getDate("day"),res.getFloat("flow"),new River(res.getInt("rid"),res.getString("name"))));
			}

			conn.close();
			st.close();
			res.close();
			return result;
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}
	}
	
}
