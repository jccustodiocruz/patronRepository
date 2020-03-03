package Repository;

import Connection.ConnectionFactory;
import Entidades.Barco;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BarcoRepository extends BaseRepository<Barco> {

    private final ConnectionFactory connection;

    public BarcoRepository(ConnectionFactory connectionFactory) {
        super(connectionFactory);
        this.connection = super.getConnectionFactory();
    }

    @Override
    void delete(int id) throws Exception {
        final String sql = "DELETE FROM Barcos WHERE id_barco = ?";

        try (Connection connection = this.connection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            statement.executeUpdate();

        }
    }

    @Override
    void update(Barco barco) throws Exception {
        final String sql = "UPDATE Barcos SET Id_Socio = ?, Nombre = ?, Amarre = ?, Cuota = ?";

        try (Connection connectionEstablecida = this.connection.getConnection(); PreparedStatement statement = connectionEstablecida.prepareStatement(sql)) {
            statement.setInt(1, barco.getIdSocio());
            statement.setString(2, barco.getNombreBarco());
            statement.setInt(3, barco.getNumAmarre());
            statement.setInt(4, barco.getCuotaAmarre());

            statement.executeUpdate();

        }
    }

    @Override
    void add(Barco barco) throws Exception {
        final String sql = "INSERT INTO Barcos(Id_Socio, Nombre, Amarre, Cuota) VALUES (?,?,?,?,)";

        try (Connection connection = this.connection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, barco.getIdSocio());
            statement.setString(2, barco.getNombreBarco());
            statement.setInt(3, barco.getNumAmarre());
            statement.setInt(4, barco.getCuotaAmarre());

            statement.executeUpdate();

        }
    }

}
