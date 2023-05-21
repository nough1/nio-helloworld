package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        try {
            FileChannel fileChannel = new FileInputStream("data.txt").getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            while(true){


                try {
                    int length = fileChannel.read(byteBuffer);
                    if(length==-1){
                        System.out.println("end");
                        break;
                    }
                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()){


                        System.out.println((char)byteBuffer.get());

                    }
                    byteBuffer.clear();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getCause());
            throw new RuntimeException(e);
        }


    }
}
