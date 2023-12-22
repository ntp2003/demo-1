package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceStatus {
	public final static String NOTCONFIRMED = "Not confirmed";
	public final static String AWAITINGDELIVERY = "Awaiting delivery";
	public final static String CANCELLED = "Cancelled";
	public final static String INPROGRESS = "In progress";
	public final static String COMPLETED = "Completed";
	public final static String UNDELIVERABLE = "Undeliverable";
	
	public static List<String> nextPossibleStatus(String value) {
		switch (value) {
		case NOTCONFIRMED:
			return Arrays.asList(AWAITINGDELIVERY, CANCELLED);
		case AWAITINGDELIVERY:
			return Arrays.asList(INPROGRESS, CANCELLED);
		case CANCELLED:
			return Arrays.asList();
		case INPROGRESS:
			return Arrays.asList(COMPLETED, UNDELIVERABLE, CANCELLED);
		case COMPLETED:
			return Arrays.asList();
		case UNDELIVERABLE:
			return Arrays.asList();
		default:
			throw new IllegalStateException("Unknown argument value !!!");
		}
	}
}
