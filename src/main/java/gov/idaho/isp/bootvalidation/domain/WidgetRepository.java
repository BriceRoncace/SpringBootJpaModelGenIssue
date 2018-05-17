package gov.idaho.isp.bootvalidation.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WidgetRepository extends JpaRepository<Widget, Long> {
}