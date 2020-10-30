package test;

import java.util.Scanner;

import java.net.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.*;


public class UDPSocketClient {
	DatagramSocket Socket;
	
	public UDPSocketClient() {
		
	}
	
	/*public void createAndListenSocket() {
		try {
			Socket = new DatagramSocket();
			InetAddress IPAddress = InetAddress.getByName("localhost");//ip of server
			byte[] incomingData = new byte[1024];
			Scanner input = new Scanner(System.in);
			String toSend = "";
			while (!toSend.equals("quit")){
				//String sentence = "this is a message from client";
				toSend = "";
				System.out.println("enter string to send: ");
				toSend = input.next();
				byte[] data = toSend.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, 9876);
				Socket.send(sendPacket);
				System.out.println("message from client sent");
				DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
				Socket.receive(incomingPacket);
				String response = new String(incomingPacket.getData());
				System.out.println("response from server: " + response);
			}
			Socket.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/


	public void establishLink() {
		try {
			Socket = new DatagramSocket();

			InetAddress IPAddress = InetAddress.getByName("localhost");
			String misc = "hey";
			byte[] data = misc.getBytes();

			DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, 9876);

			Socket.send(sendPacket);

			System.out.println("link request sent from client");

			byte[] incomingData = new byte[1024];
			DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
			Socket.receive(incomingPacket);
			String response = new String(incomingPacket.getData());
			System.out.println("Response from server:" + response);

			//Socket.close();

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		} //catch (InterruptedException e) {
			//e.printStackTrace();
		//}
	}
	
	public void receiveSocket() {
		try{
			byte[] incomingData = new byte[1024];
			while(true){

				DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
				Socket.receive(incomingPacket);
				byte[] data = incomingPacket.getData();
				ByteArrayInputStream in = new ByteArrayInputStream(data);
				ObjectInputStream is = new ObjectInputStream(in);

				try {
					GameTest game = (GameTest) is.readObject();
					System.out.println("GameTest received = "+ game);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}


				//incomingData = new byte[1024];
				//DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
				//Socket.receive(incomingPacket);
				//String message = new String(incomingPacket.getData());
				
				//System.out.println("gameprinted:  " + game);


			}	

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		} //catch (InterruptedException e) {
			//e.printStackTrace();
		//}
		
	}
	
	public static void main(String[] args) {
		UDPSocketClient client = new UDPSocketClient();
		//client.createAndListenSocket();
		client.establishLink();
		client.receiveSocket();
	}
	
}
