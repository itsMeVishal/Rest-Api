package com.vish.security.security.demo.serilizer;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.vish.security.security.demo.exceptions.model.ErrorDetails;

public class ErrorDetailSerilizer extends StdSerializer<ErrorDetails>{

	protected ErrorDetailSerilizer(Class<ErrorDetails> t) {
		super(t);
		}

	@Override
	public void serialize(ErrorDetails value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = format.format(value.getTimestamp());
		//gen.writeStartObject();
		gen.writeString(formattedDate);
		gen.writeString(value.getMessage());
		gen.writeString(value.getDetails());
		
		//gen.writeStartObject();
	}

	
}
