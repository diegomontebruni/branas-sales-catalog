package com.montebruni.salescatalog.infra.repository.postgres.port

import com.montebruni.salescatalog.infra.repository.postgres.model.ProductPostgresqlModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductPostgresqlRepository : JpaRepository<ProductPostgresqlModel, UUID>
