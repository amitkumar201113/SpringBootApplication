package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.model.Movie;

@Repository
public class MovieDao {
	@Autowired
	JdbcTemplate jdbctemplate;
	public MovieDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	
    public Movie getMovieById(Integer id) {

    	 List<Movie> result = new ArrayList<Movie>();
       return jdbctemplate.queryForObject("SELECT * FROM movie_tbl where movie_ID=1", new RowMapper<Movie>() {

		public Movie mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			Movie movie=new Movie();
			//movie.setMovie_ID(movie_ID);
			movie.setMovie_name(rs.getString("movie_Name"));
			return movie;
		}
	});
                
        //return result;

    }
    
    
    public List<Movie> getMovieByAllMovies() {
    
    	return jdbctemplate.query("select * from movie_tbl",new RowMapper<Movie>() {

			public Movie mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Movie movie=new Movie();
				movie.setMovie_ID(rs.getInt(1));  
				movie.setMovie_name(rs.getString(2));  
				return movie;
			}
		});
    	     
    	

    
    }
    
    public Boolean saveMovie(final Movie movie){
		
    	String query="insert into movie_tbl(movie_Name) values(?)";
    	return jdbctemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				 ps.setString(1,movie.getMovie_name());  
				 return ps.execute();  
			}
		});
    	
    	
    }
    
public Boolean updateMovie(final Movie movie){
		
    	String query="update movie_tbl set movie_Name=? where movie_ID=?";
    	return jdbctemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				 ps.setString(1,movie.getMovie_name()); 
				 ps.setInt(2,movie.getMovie_ID());  
				 return ps.execute();  
			}
		});
    	
    	
    }
    
    
}


