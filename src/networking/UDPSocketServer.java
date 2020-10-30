package test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.*;


public class UDPSocketServer {
	DatagramSocket socket = null;
	int[] clients;
	InetAddress[] IPs;
	int cnum;
	//ArrayList<Int> connections;

	public UDPSocketServer(int num) {
		this.clients = new int[num];
		this.IPs = new InetAddress[num];
		this.cnum = num;
	}


	public void establishConnections() {
		try {
			socket = new DatagramSocket(9876);
			for(int i = 0; i < cnum; i++){
					
					byte[] incomingData = new byte[1024];

					DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
					socket.receive(incomingPacket);
					
/*
					byte[] data = incomingPacket.getData();
					ByteArrayInputStream in = new ByteArrayInputStream(data);
					ObjectInputStream is = new ObjectInputStream(in);

					try {
						OBJECT object = (OBJECT) is.readObject();
						System.out.println("oBJECT object received = "+object);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}

*/

					InetAddress IPAddress = incomingPacket.getAddress();
					int port = incomingPacket.getPort();

					clients[i] = port;
					IPs [i] = IPAddress;


					String reply = "Thank you for the message" + Integer.toString(clients[i]);
					byte[] data = reply.getBytes();
					DatagramPacket replyPacket = new DatagramPacket(data, data.length, IPs[i], clients[i]);
					socket.send(replyPacket);
					//Thread.sleep(2000);
			}	

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		} //catch (InterruptedException e) {
			//e.printStackTrace();
		//}
	}

	public void sendSocket() {
		GameTest game = new GameTest();
		try{
			for(int i = 0; i < 10; i++){
				game.update();
				for( int k = 0; k < cnum; k++){
					InetAddress IPAddress = IPs[k];
					int port = clients[k];
					

					//String message = "message" + Integer.toString(i);//these two not needed for obj stream
				    //byte[] data = message.getBytes();////////////////////////////////////////////


					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					ObjectOutputStream os = new ObjectOutputStream(outputStream);
					os.writeObject(game);
					byte[] data = outputStream.toByteArray();


				    DatagramPacket replyPacket = new DatagramPacket(data, data.length, IPAddress, port);

				    socket.send(replyPacket);

				    System.out.println("sending message");

				    
				}
			Thread.sleep(3000);
			}
			socket.close();

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*public void createAndListenSocket() {
		try {
			socket = new DatagramSocket(9876);
			byte[] incomingData = new byte[1024];
			String condition = "";

			while (!condition.equals("quit")) {
				condition = "";
				incomingData = new byte[1024];

				DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
				System.out.println("waiting for packet...");
				socket.receive(incomingPacket);

				String message = new String(incomingPacket.getData());
				condition = message;
				System.out.println("received message from cliient : " + condition);

				InetAddress IPAddress = incomingPacket.getAddress();
				int port = incomingPacket.getPort();
				String reply = "Thank you for the message";
				byte[] data = reply.getBytes();
				DatagramPacket replyPacket = new DatagramPacket(data, data.length, IPAddress, port);
				socket.send(replyPacket);

				Thread.sleep(2000);
				
			}
			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}*/
	
	//public void sendSocket()

	public void printHello(){
		for(int i = 0; i < 10; i++){
			System.out.println("hello world");
			try {

				Thread.sleep(4000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	
	public static void main(String[] args) {

		UDPSocketServer server = new UDPSocketServer(2);
		//Thread t1 = new Thread(new Runnable() {
			//@Override
			//public void run() {
			///	server.printHello();
			//}
		//});
		//t1.start();
		server.establishConnections();
		//server.createAndListenSocket();
		server.sendSocket();
	}
	
}
