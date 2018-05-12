package services;

import com.google.gson.Gson;
import com.buster.models.Report;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created by Ramon on 5/12/2018.
 */
public class BusterMessageProducer {

    public void sendMessage(Report report) throws JMSException {
        // Create a ConnectionFactory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("http://localhost");

        // Create a Connection
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // Create a Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue(report.type);

        // Create a MessageProducer from the Session to the Topic or Queue
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        //TODO: eto yung gagawing message, mas okay na json to galing dun sa report class
        Gson gson = new Gson();
        String text = gson.toJson(report);

        TextMessage message = session.createTextMessage(text);

        // Tell the producer to send the message
        System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
        producer.send(message);

        // Clean up
        session.close();
        connection.close();
    }

}
