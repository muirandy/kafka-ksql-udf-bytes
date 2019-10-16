package com.aimyourtechnology.kafka.ksql.udf.bytes;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;
import org.apache.kafka.connect.data.Struct;

@UdfDescription(name = "bytesConverter", description = "Convert an Array of bytes to something more useful")
public class BytesConverter {
    @Udf(description = "Convert field to a String")
    public String bytesConverter(@UdfParameter(schema="STRUCT<SCALE INTEGER, VALUE ARRAY>") Struct struct,
                                 @UdfParameter("path") String pathToBytes) {
        System.out.println("STRUCT IN UDF: " + struct);
        System.out.println("STRUCT IN UDF as bytes: " + struct.toString().getBytes());
        System.out.println("Size of STRUCT IN UDF as bytes: " + struct.toString().getBytes().length);
        System.out.println("Path: " + pathToBytes);
        return "666";
    }

    @Udf(description = "Convert field to a String")
    public String bytesConverter(String pathToBytes) {
        System.out.println("Path: " + pathToBytes);
        return "666";
    }
}
