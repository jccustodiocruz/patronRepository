
package Repository;

import Connection.ConnectionFactory;

public abstract class BaseRepository<T> {

    private final ConnectionFactory connectionFactory;

    public BaseRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    void add(T objeto) throws Exception {}

    void update(T objeto) throws Exception {}

    void delete(int id) throws Exception {}        

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

}
