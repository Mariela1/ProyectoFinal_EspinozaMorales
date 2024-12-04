import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.banco.xyz.clientes.model.Cliente;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {
    // Aquí puedes agregar métodos personalizados si es necesario
}

