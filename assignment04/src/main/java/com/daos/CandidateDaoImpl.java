package com.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entities.Candidate;

public class CandidateDaoImpl extends Dao implements CandidateDao {

	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtfindById;
	private PreparedStatement stmtSave;
	private PreparedStatement stmtUpdate;
	private PreparedStatement stmtDelete;
	private PreparedStatement stmtIncrVote;

	public CandidateDaoImpl() throws Exception {
		String sqlFindAll = "SELECT * FROM candidates";
		stmtFindAll = con.prepareStatement(sqlFindAll);

		String sqlFindById = "SELECT * FROM candidates WHERE id = ?";
		stmtfindById = con.prepareStatement(sqlFindById);

		String sqlSave = "INSERT INTO candidates(name,party,votes) VALUES (?,?,?)";
		stmtSave = con.prepareStatement(sqlSave);

		String sqlUpdate = "UPDATE candidates SET name=?,party=?,votes=? WHERE id=?";
		stmtUpdate = con.prepareStatement(sqlUpdate);

		String sqlDelete = "DELETE FROM candidates WHERE id = ?";
		stmtDelete = con.prepareStatement(sqlDelete);

		String sqlIncrVote = "UPDATE candidates SET votes = votes + 1 WHERE id = ?";
		stmtIncrVote = con.prepareStatement(sqlIncrVote);

	}

	@Override
	public void close() throws Exception {
		super.close();
		stmtFindAll.close();
		stmtfindById.close();
		stmtSave.close();
		stmtUpdate.close();
		stmtIncrVote.close();
	}

	@Override
	public List<Candidate> findAll() throws Exception {

		List<Candidate> list = new ArrayList<Candidate>();

		try (ResultSet rs = stmtFindAll.executeQuery()) {

			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				String party = rs.getString("party");
				int votes = rs.getInt("votes");

				Candidate c = new Candidate(id, name, party, votes);
				list.add(c);
			}
		} // rs.close()

		return list;
	}

	@Override
	public Candidate findBYId(int id) throws Exception {
		stmtfindById.setInt(1, id);

		try (ResultSet rs = stmtfindById.executeQuery()) {

			if (rs.next()) {

				id = rs.getInt("id");
				String name = rs.getNString("name");
				String party = rs.getNString("party");
				int votes = rs.getInt("votes");

				Candidate c = new Candidate(id, name, party, votes);
				return c;
			}

		} // rs.close();

		return null;
	}

	@Override
	public int save(Candidate c) throws Exception {

		stmtSave.setString(1, c.getName());
		stmtSave.setString(2, c.getParty());
		stmtSave.setInt(3, c.getVotes());

		int count = stmtSave.executeUpdate();

		return count;
	}

	@Override
	public int update(Candidate c) throws Exception {

		stmtUpdate.setString(1, c.getName());
		stmtUpdate.setString(2, c.getParty());
		stmtUpdate.setInt(3, c.getVotes());
		stmtUpdate.setInt(4, c.getId());

		int count = stmtUpdate.executeUpdate();

		return count;

	}

	@Override
	public int deleteById(int id) throws Exception {

		stmtDelete.setInt(1, id);
		int count = stmtDelete.executeUpdate();
		return count;
	}

	@Override
	public int incrVote(int candId) throws Exception {
		stmtIncrVote.setInt(1, candId);
		int count = stmtIncrVote.executeUpdate();
		return count;
	}
}
