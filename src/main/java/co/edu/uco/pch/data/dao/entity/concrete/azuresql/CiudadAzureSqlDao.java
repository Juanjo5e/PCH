package co.edu.uco.pch.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.pch.crosscutting.Exception.custome.DataPCHException;
import co.edu.uco.pch.data.dao.entity.CiudadDAO;
import co.edu.uco.pch.data.dao.entity.DepartamentoDAO;
import co.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.pch.entity.CiudadEntity;
import co.edu.uco.pch.entity.DepartamentoEntity;

public final class CiudadAzureSqlDao extends SqlConnection implements CiudadDAO {

    public CiudadAzureSqlDao(Connection connection) {
        super(connection);
    }

    @Override
    public void crear(CiudadEntity data) {
        final StringBuilder sentencialSql = new StringBuilder();
        sentencialSql.append("INSERT INTO Ciudad (in, nombre, departamento) ");
        sentencialSql.append("SELECT ?, ?, ?");

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentencialSql.toString())) {

            sentenciaSqlPreparada.setObject(1, data.getId());
            sentenciaSqlPreparada.setString(2, data.getNombre());
            sentenciaSqlPreparada.setObject(3, data.getDepartamento().getId());

            sentenciaSqlPreparada.executeUpdate();

        } catch (SQLException excepcion) {
            var mensajeUsuario = "Se ha presentado un problema tratando de crear la ciudad \"${1}\"Por favor intente de nuevo y si el problema persiste contacte al administrador.";
            var mensajeTecnico = "Se ha presenado una excepcion de tipo SQLException tratando de realizar el insert de la ciudad \"${1}\"en la tabla \"Pais\" de la base de datos Azure SQL. Para mas detalles revice de forma completa la excepcion raiz presentada. ";

            throw new DataPCHException(mensajeTecnico, mensajeUsuario, excepcion);

        } catch (Exception excepcion) {
            var mensajeUsuario = "Se ha presentado un problema tratando de crear la ciudad \"${1}\"Por favor intente de nuevo y si el problema persiste contacte al administrador.";
            var mensajeTecnico = "Se ha presenado un problema inesperado de tipo Exception. Para mas detalles revice de forma completa la excepcion raiz presentada. ";

            throw new DataPCHException(mensajeTecnico, mensajeUsuario, excepcion);

        }
    }

    public class CiudadAzureSqlDAO extends SqlConnection implements CiudadDAO {

        private final DepartamentoDAO departamentoDAO;

        public CiudadAzureSqlDAO(final Connection connection, final DepartamentoDAO departamentoDAO) {
            super(connection);
            this.departamentoDAO = departamentoDAO;
        }

        @Override
        public final void crear(final CiudadEntity data) {
            final StringBuilder sentenciasSql = new StringBuilder();

            sentenciasSql.append("INSERT INTO ciudad (id, nombre, departamento) ");
            sentenciasSql.append("VALUES (?, ?, ?)");

            try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciasSql.toString())) {
                sentenciaSqlPreparada.setObject(1, data.getId());
                sentenciaSqlPreparada.setString(2, data.getNombre());
                sentenciaSqlPreparada.setObject(3, data.getDepartamento().getId());

                sentenciaSqlPreparada.executeUpdate();

            } catch (final SQLException exception) {
                var mensajeUsuario = "Se ha presentado un problema tratando de crear la ciudad \"" + data.getNombre() + "\" por favor intente de nuevo y si el problema persiste contacte al administrador...";
                var mensajeTecnico = "Se ha presentado una excepción de tipo SQLException tratando de realizar el INSERT de la ciudad \"" + data.getNombre() + "\" para más detalles revise la excepción raíz presentada..";

                throw new DataPCHException(mensajeTecnico, mensajeUsuario, exception);
            } catch (final Exception exception) {
                var mensajeUsuario = "Se ha presentado un problema tratando de crear la ciudad \"" + data.getNombre() + "\" por favor intente de nuevo y si el problema persiste contacte al administrador...";
                var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar el INSERT de la ciudad \"" + data.getNombre() + "\" para más detalles revise la excepción raíz presentada..";

                throw new DataPCHException(mensajeTecnico, mensajeUsuario, exception);
            }
        }

        @Override
        public final List<CiudadEntity> consultar(final CiudadEntity data) {
            final List<CiudadEntity> ciudades = new ArrayList<>();
            String sentenciasSql = "SELECT id, nombre, departamento " + "FROM ciudad ";

            if (data != null) {
                boolean whereAdded = false;
                if (data.getId() != null) {
                    sentenciasSql += "WHERE id = ? ";
                    whereAdded = true;
                }
                if (data.getNombre() != null && !data.getNombre().isEmpty()) {
                    sentenciasSql += (whereAdded ? "AND " : "WHERE ") + "nombre LIKE ? ";
                    whereAdded = true;
                }
                if (data.getDepartamento() != null && data.getDepartamento().getId() != null) {
                    sentenciasSql += (whereAdded ? "AND " : "WHERE ") + "departamento = ? ";
                }
            }

            try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciasSql)) {

                int index = 1;
                if (data != null) {
                    if (data.getId() != null) {
                        sentenciaSqlPreparada.setObject(index++, data.getId());
                    }
                    if (data.getNombre() != null && !data.getNombre().isEmpty()) {
                        sentenciaSqlPreparada.setString(index++, "%" + data.getNombre() + "%");
                    }
                    if (data.getDepartamento() != null && data.getDepartamento().getId() != null) {
                        sentenciaSqlPreparada.setObject(index++, data.getDepartamento().getId());
                    }
                }

                try (var resultado = sentenciaSqlPreparada.executeQuery()) {
                    while (resultado.next()) {
                        CiudadEntity ciudad = new CiudadEntity();
                        ciudad.setId((UUID) resultado.getObject("id"));
                        ciudad.setNombre(resultado.getString("nombre"));

                        UUID departamentoId = (UUID) resultado.getObject("departamento");
                        DepartamentoEntity departamento = departamentoDAO.obtenerPorId(departamentoId);
                        ciudad.setDepartamento(departamento);

                        ciudades.add(ciudad);
                    }
                }

            } catch (final SQLException exception) {
                var mensajeUsuario = "Se ha presentado un problema tratando de consultar las ciudades por favor intente de nuevo y si el problema persiste contacte al administrador...";
                var mensajeTecnico = "Se ha presentado una excepción de tipo SQLException tratando de realizar la consulta de las ciudades para más detalles revise la excepción raíz presentada..";

                throw new DataPCHException(mensajeTecnico, mensajeUsuario, exception);
            } catch (final Exception exception) {
                var mensajeUsuario = "Se ha presentado un problema tratando de consultar las ciudades por favor intente de nuevo y si el problema persiste contacte al administrador...";
                var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de las ciudades para más detalles revise la excepción raíz presentada..";

                throw new DataPCHException(mensajeTecnico, mensajeUsuario, exception);
            }

            return ciudades;
        }

        @Override
        public final void modificar(final CiudadEntity data) {
            final StringBuilder sentenciasSql = new StringBuilder();

            sentenciasSql.append("UPDATE ciudad ");
            sentenciasSql.append("SET nombre = ?, departamento = ? ");
            sentenciasSql.append("WHERE id = ?");

            try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciasSql.toString())) {

                sentenciaSqlPreparada.setString(1, data.getNombre());
                sentenciaSqlPreparada.setObject(2, data.getDepartamento().getId());
                sentenciaSqlPreparada.setObject(3, data.getId());

                sentenciaSqlPreparada.executeUpdate();

            } catch (final SQLException exception) {
                var mensajeUsuario = "Se ha presentado un problema tratando de modificar la ciudad \"" + data.getNombre() + "\" por favor intente de nuevo y si el problema persiste contacte al administrador...";
                var mensajeTecnico = "Se ha presentado una excepción de tipo SQLException tratando de realizar el UPDATE de la ciudad \"" + data.getNombre() + "\" para más detalles revise la excepción raíz presentada..";

                throw new DataPCHException(mensajeTecnico, mensajeUsuario, exception);
            } catch (final Exception exception) {
                var mensajeUsuario = "Se ha presentado un problema tratando de modificar la ciudad \"" + data.getNombre() + "\" por favor intente de nuevo y si el problema persiste contacte al administrador...";
                var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar el UPDATE de la ciudad \"" + data.getNombre() + "\" para más detalles revise la excepción raíz presentada..";

                throw new DataPCHException(mensajeTecnico, mensajeUsuario, exception);
            }
        }

        @Override
        public final void eliminar(final UUID id) {
            final StringBuilder sentenciasSql = new StringBuilder();

            sentenciasSql.append("DELETE FROM ciudad ");
            sentenciasSql.append("WHERE id = ?");

            try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciasSql.toString())) {

                sentenciaSqlPreparada.setObject(1, id);

                sentenciaSqlPreparada.executeUpdate();

            } catch (final SQLException exception) {
                var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la ciudad con ID \"" + id + "\" por favor intente de nuevo y si el problema persiste contacte al administrador...";
                var mensajeTecnico = "Se ha presentado una excepción de tipo SQLException tratando de realizar el DELETE de la ciudad con ID \"" + id + "\" para más detalles revise la excepción raíz presentada..";

                throw new DataPCHException(mensajeTecnico, mensajeUsuario, exception);
            } catch (final Exception exception) {
                var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la ciudad con ID \"" + id + "\" por favor intente de nuevo y si el problema persiste contacte al administrador...";
                var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar el DELETE de la ciudad con ID \"" + id + "\" para más detalles revise la excepción raíz presentada..";

                throw new DataPCHException(mensajeTecnico, mensajeUsuario, exception);
            }
        }
    }

	@Override
	public List<CiudadEntity> consultar(CiudadEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(CiudadEntity data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID data) {
		// TODO Auto-generated method stub
		
	}

	
}
