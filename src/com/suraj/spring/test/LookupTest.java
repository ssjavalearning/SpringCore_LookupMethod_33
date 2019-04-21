package com.suraj.spring.test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.suraj.spring.beans.Ticket;
import com.suraj.spring.beans.TicketVendingMachine;

public class LookupTest {

	public static void main(String[] args) {
		ApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("spring.xml");
			TicketVendingMachine machine = context.getBean("machine", TicketVendingMachine.class);
			Ticket ticket = machine.generateTicket();
			System.out.println(ticket.printTicket());
		}catch(BeansException e) {
			e.printStackTrace();
		}finally {
			((AbstractApplicationContext) context).close();
		}
	}
}
