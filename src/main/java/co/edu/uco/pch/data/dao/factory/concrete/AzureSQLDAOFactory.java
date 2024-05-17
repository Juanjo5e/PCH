package co.edu.uco.pch.data.dao.factory.concrete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.pch.crosscutting.helper.SQLHelper;
import co.edu.uco.pch.data.dao.entity.CiudadDAO;
import co.edu.uco.pch.data.dao.entity.DepartamentoDAO;
import co.edu.uco.pch.data.dao.entity.PaisDAO;
import co.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.pch.data.dao.entity.concrete.azuresql.CiudadAzureSqlDao;
import co.edu.uco.pch.data.dao.entity.concrete.azuresql.DepartamentoAzureSqlDAO;
import co.edu.uco.pch.data.dao.entity.concrete.azuresql.PaisAzureSqlDAO;
import co.edu.uco.pch.data.dao.factory.DAOFactory;

public final class AzureSQLDAOFactory extends SqlConnection implements DAOFactory {
	
	

	protected AzureSQLDAOFactory() {
		super();
		abrirConexion();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void abrirConexion() {
		try {
			String connectionString = "";
			setConexion(DriverManager.getConnection(connectionString));
		}catch(final SQLException exeption){
			
		}catch (final Exception exception) {
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cerrarConexion() {
		SQLHelper.close(getConexion());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciarTransaccion() {
		SQLHelper.initTransaction(getConexion());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarTransaccion() {
		SQLHelper.commit(getConexion());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarTransaccion() {
		SQLHelper.rollback(getConexion());
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaisDAO getPaisDAO() {
		return new PaisAzureSqlDAO(getConexion());
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		return new DepartamentoAzureSqlDAO(getConexion());
	}

	@Override
	public CiudadDAO getCiudadDAO() {
		return new CiudadAzureSqlDao(getConexion());
	}
	

}
