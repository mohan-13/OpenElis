package org.bahmni.feed.openelis.externalreference.daoimpl;

import org.bahmni.feed.openelis.externalreference.valueholder.ExternalReference;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;
import us.mn.state.health.lims.hibernate.HibernateUtil;

public class ExternalReferenceDaoImplTest {

    ExternalReferenceDaoImpl externalReferenceDao = new ExternalReferenceDaoImpl();

    @Test
    public void testInsertData() throws Exception {
           ExternalReference reference = new ExternalReference();
            reference.setExternalId("1123456");
            reference.setItemId(1123457);
            reference.setType("Test");

            Transaction transaction = HibernateUtil.getSession().beginTransaction();
            externalReferenceDao.insertData(reference);
            transaction.commit();

            reference = externalReferenceDao.getData("1123456");
            Assert.assertNotNull(reference);

            transaction = HibernateUtil.getSession().beginTransaction();
            externalReferenceDao.deleteData(reference);
            transaction.commit();

    }

}