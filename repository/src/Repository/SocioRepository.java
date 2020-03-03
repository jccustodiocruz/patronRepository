package Repository;

import Connection.ConnectionFactory;
import Entidades.Socio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SocioRepository extends BaseRepository<Socio> {

    private final ConnectionFactory connection;

    public SocioRepository(ConnectionFactory connectionFactory) {
        super(connectionFactory);
        this.connection = super.getConnectionFactory();
    }

    @Override
    void delete(int id) throws Exception {
        String sql = "DELETE FROM Socios WHERE Id_socio=?";

        try (Connection connectionEstablecida = this.connection.getConnection(); PreparedStatement statement = connectionEstablecida.prepareStatement(sql)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate(sql);
        }
    }

    @Override
    void update(Socio socio) throws Exception {
        String sql = "UPDATE Socios SET Nombre = ?, Direccion = ? WHERE Id_Socio = ?";

        try (Connection connectionEstablecida = this.connection.getConnection(); PreparedStatement statement = connectionEstablecida.prepareStatement(sql)) {
            statement.setString(1, socio.getNombre());
            statement.setString(2, socio.getDireccion());
            statement.setInt(3, socio.getId());

            statement.executeUpdate(sql);

        }
    }

    @Override
    void add(Socio socio) throws Exception {
        String sql = "INSERT INTO Socios (Nombre, Direccion) VALUES (?,?)";

        try (Connection connectionEstablecida = this.connection.getConnection(); PreparedStatement statement = connectionEstablecida.prepareStatement(sql)) {
            statement.setString(1, socio.getNombre());
            statement.setString(2, socio.getDireccion());

            statement.executeLargeUpdate(sql);
        }
    }
}
