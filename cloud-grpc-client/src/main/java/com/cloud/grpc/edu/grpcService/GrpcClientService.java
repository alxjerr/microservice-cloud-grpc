package com.cloud.grpc.edu.grpcService;

import com.cloud.grpc.lib.HelloReply;
import com.cloud.grpc.lib.HelloRequest;
import com.cloud.grpc.lib.SimpleGrpc;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * emil:miles02@613.com
 * Created by forezp on 2018/8/11.
 */

@Service
public class GrpcClientService {

    @GrpcClient("cloud-grpc-server")
    private Channel serverChannel;

    public String sendMessage(String name) {
        SimpleGrpc.SimpleBlockingStub stub = SimpleGrpc.newBlockingStub(serverChannel);
        HelloReply response = stub.sayHello(HelloRequest.newBuilder().setName(name).build());
        return response.getMessage();
    }
}
