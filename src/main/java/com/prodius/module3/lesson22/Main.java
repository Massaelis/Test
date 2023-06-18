package com.prodius.module3.lesson22;

import com.prodius.module3.lesson22.config.HibernateFactoryUtil;
import com.prodius.module3.lesson22.dto.CountCustomerDTO;
import com.prodius.module3.lesson22.model.Customer;
import com.prodius.module3.lesson22.model.Order;
import org.flywaydb.core.Flyway;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Main {
    public static void main(String[] args) {
        /*final Order order = new Order();
        order.setService("IOP-456");

        final Visit visit1 = new Visit();
        final Visit visit2 = new Visit();

        final Platform platform1 = new Platform();
        final Platform platform2 = new Platform();

        final Customer customer = new Customer();
        customer.setName("John");
        customer.setAge(30);
        customer.setOrder(order);
        customer.setVisits(Set.of(visit1, visit2));
        customer.setPlatforms(Set.of(platform1, platform2));

        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();

        final Customer reference = entityManager.getReference(Customer.class, customer.getId());
        System.out.println(reference);*/

        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/test", "postgres", "root")
                .baselineOnMigrate(true)
                .locations("db/migration/lesson26")
                .load();
        flyway.migrate();
    }

    private void criteriaExamples() {
        final Customer customer = new Customer();
        customer.setName("John");
        customer.setAge(30);

        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();

        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        final Root<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.select(root);
        entityManager.createQuery(criteriaQuery)
                .getResultList()
                .forEach(System.out::println);

        final CriteriaBuilder criteriaBuilder2 = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Customer> criteriaQuery2 = criteriaBuilder2.createQuery(Customer.class);
        final Root<Customer> root2 = criteriaQuery2.from(Customer.class);
        criteriaQuery2.select(root2);
        criteriaQuery2.where(criteriaBuilder2.greaterThan(root2.get("age"), 5));
        entityManager.createQuery(criteriaQuery2)
                .getResultList()
                .forEach(System.out::println);
    }

    private void simpleExamples() {
        final Order order = new Order();
        order.setService("order");

        final Customer customer = new Customer();
        customer.setName("John");
        customer.setAge(30);
        customer.setOrder(order);


        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        final Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        session1.save(order);
        session1.save(customer);
        session1.getTransaction().commit();
        session1.close();

        System.out.println("Get");
        final Session session2 = sessionFactory.openSession();
        final Customer customer1 = session2.get(Customer.class, customer.getId());
        System.out.println(customer1);
        System.out.println(customer1.getOrder());
        session2.close();

        System.out.println("Get from HQL");
        final Session session3 = sessionFactory.openSession();
        session3.createQuery("from Customer", Customer.class)
                .list()
                .forEach(System.out::println);

        System.out.println("Get from HQL with params");
        session3.createQuery("from Customer c where c.age = :age", Customer.class)
                .setParameter("age", 30)
                .list()
                .forEach(System.out::println);


        System.out.println("Get DTO from HQL");
        session3.createQuery("select new com.prodius.module3.lesson22.dto.CountCustomerDTO(count(*)) from Customer c "
                        + "where c.age = :age", CountCustomerDTO.class)
                .setParameter("age", 30)
                .list()
                .forEach(System.out::println);
        session3.close();


        System.out.println("Get from SQL");
        final Session session4 = sessionFactory.openSession();
        session4.createNativeQuery("SELECT * FROM Customer", Customer.class)
                .list()
                .forEach(System.out::println);

        System.out.println("Get scalar from SQL");
        session4.createNativeQuery("SELECT count(*) as c FROM Customer")
                .addScalar("c", IntegerType.INSTANCE)
                .list()
                .forEach(System.out::println);

        System.out.println("Get DTO from SQL");
        session4.createNativeQuery("SELECT count(*) as c FROM Customer")
                .setResultTransformer(Transformers.aliasToBean(CountCustomerDTO.class))
                .list()
                .forEach(System.out::println);
        session4.close();
    }
}
