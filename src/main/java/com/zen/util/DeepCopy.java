package com.zen.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeepCopy {

	private static final Logger LOG = LoggerFactory.getLogger(DeepCopy.class.getName());

	public static Object deepCopy(final Object oldValue) throws IOException,
			ClassNotFoundException {
		Serializable newValue = null;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(bout);
			oos.writeObject(oldValue);
			ByteArrayInputStream bin = new ByteArrayInputStream(
					bout.toByteArray());
			ois = new ObjectInputStream(bin);
			newValue = (Serializable) ois.readObject();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (ois != null) {
					ois.close();
				}
			} catch (Exception e) {
				LOG.error("Error closing Stream");
			}
		}
		return newValue;
	}

}
