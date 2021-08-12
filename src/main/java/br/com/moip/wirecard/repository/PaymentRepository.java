package br.com.moip.wirecard.repository;

import br.com.moip.wirecard.domain.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
