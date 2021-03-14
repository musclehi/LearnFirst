package com.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {
    public static void main(String[] args) throws Exception{
        //打开文件通道
        RandomAccessFile aFile = new RandomAccessFile("data/com.nio-data.txt", "rw");
        FileChannel channel = aFile.getChannel();

//        从文件通道内读取数据，read的返回值代表有多少字节被写入了Buffer，返回-1则表示已经读取到文件结尾了。
        ByteBuffer buf = ByteBuffer.allocate(60);

        //设置读取的位置
        long pos = channel.position();
        System.out.println(pos);
        channel.position(60);
        System.out.println(channel.position());

        //        利用truncate方法可以截取指定长度的文件，会直接修改文件
//        channel.truncate(110);

        int bytesRead = channel.read(buf);
//        System.out.println(bytesRead);



        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            buf.clear();
            bytesRead = channel.read(buf);
        }



//        size()方法可以返回FileChannel对应的文件的文件大小
        long fileSize = channel.size();
        System.out.println(fileSize);



//        force方法会把所有未写磁盘的数据都强制写入磁盘。这是因为在操作系统中出于性能考虑回把数据放入缓冲
//        区，所以不能保证数据在调用write写入文件通道后就及时写到磁盘上了，除非手动调用force方法。 force方法
//        需要一个布尔参数，代表是否把meta data也一并强制写入。
        channel.force(false);

//        向文件通道写入数据
        String newData = "New String to write to file..." + System.currentTimeMillis();
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();
        while(buf.hasRemaining()) {
            channel.write(buf);
        }

//        关闭通道
        channel.close();

    }
}
