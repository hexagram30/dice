package hxgm30.dice.pb.api;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0)",
    comments = "Source: dice.proto")
public final class ServiceAPIGrpc {

  private ServiceAPIGrpc() {}

  public static final String SERVICE_NAME = "api.ServiceAPI";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<hxgm30.dice.pb.api.PingRequest,
      hxgm30.dice.pb.api.PingReply> getPingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Ping",
      requestType = hxgm30.dice.pb.api.PingRequest.class,
      responseType = hxgm30.dice.pb.api.PingReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<hxgm30.dice.pb.api.PingRequest,
      hxgm30.dice.pb.api.PingReply> getPingMethod() {
    io.grpc.MethodDescriptor<hxgm30.dice.pb.api.PingRequest, hxgm30.dice.pb.api.PingReply> getPingMethod;
    if ((getPingMethod = ServiceAPIGrpc.getPingMethod) == null) {
      synchronized (ServiceAPIGrpc.class) {
        if ((getPingMethod = ServiceAPIGrpc.getPingMethod) == null) {
          ServiceAPIGrpc.getPingMethod = getPingMethod =
              io.grpc.MethodDescriptor.<hxgm30.dice.pb.api.PingRequest, hxgm30.dice.pb.api.PingReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Ping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hxgm30.dice.pb.api.PingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hxgm30.dice.pb.api.PingReply.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceAPIMethodDescriptorSupplier("Ping"))
              .build();
        }
      }
    }
    return getPingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<hxgm30.dice.pb.api.RollRequest,
      hxgm30.dice.pb.api.DiceRoll> getRollMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Roll",
      requestType = hxgm30.dice.pb.api.RollRequest.class,
      responseType = hxgm30.dice.pb.api.DiceRoll.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<hxgm30.dice.pb.api.RollRequest,
      hxgm30.dice.pb.api.DiceRoll> getRollMethod() {
    io.grpc.MethodDescriptor<hxgm30.dice.pb.api.RollRequest, hxgm30.dice.pb.api.DiceRoll> getRollMethod;
    if ((getRollMethod = ServiceAPIGrpc.getRollMethod) == null) {
      synchronized (ServiceAPIGrpc.class) {
        if ((getRollMethod = ServiceAPIGrpc.getRollMethod) == null) {
          ServiceAPIGrpc.getRollMethod = getRollMethod =
              io.grpc.MethodDescriptor.<hxgm30.dice.pb.api.RollRequest, hxgm30.dice.pb.api.DiceRoll>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Roll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hxgm30.dice.pb.api.RollRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hxgm30.dice.pb.api.DiceRoll.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceAPIMethodDescriptorSupplier("Roll"))
              .build();
        }
      }
    }
    return getRollMethod;
  }

  private static volatile io.grpc.MethodDescriptor<hxgm30.dice.pb.api.RollsRequest,
      hxgm30.dice.pb.api.DiceRolls> getRollNMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RollN",
      requestType = hxgm30.dice.pb.api.RollsRequest.class,
      responseType = hxgm30.dice.pb.api.DiceRolls.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<hxgm30.dice.pb.api.RollsRequest,
      hxgm30.dice.pb.api.DiceRolls> getRollNMethod() {
    io.grpc.MethodDescriptor<hxgm30.dice.pb.api.RollsRequest, hxgm30.dice.pb.api.DiceRolls> getRollNMethod;
    if ((getRollNMethod = ServiceAPIGrpc.getRollNMethod) == null) {
      synchronized (ServiceAPIGrpc.class) {
        if ((getRollNMethod = ServiceAPIGrpc.getRollNMethod) == null) {
          ServiceAPIGrpc.getRollNMethod = getRollNMethod =
              io.grpc.MethodDescriptor.<hxgm30.dice.pb.api.RollsRequest, hxgm30.dice.pb.api.DiceRolls>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RollN"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hxgm30.dice.pb.api.RollsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hxgm30.dice.pb.api.DiceRolls.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceAPIMethodDescriptorSupplier("RollN"))
              .build();
        }
      }
    }
    return getRollNMethod;
  }

  private static volatile io.grpc.MethodDescriptor<hxgm30.dice.pb.api.RollVariousRequest,
      hxgm30.dice.pb.api.VariousDiceRolls> getRollVariousMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RollVarious",
      requestType = hxgm30.dice.pb.api.RollVariousRequest.class,
      responseType = hxgm30.dice.pb.api.VariousDiceRolls.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<hxgm30.dice.pb.api.RollVariousRequest,
      hxgm30.dice.pb.api.VariousDiceRolls> getRollVariousMethod() {
    io.grpc.MethodDescriptor<hxgm30.dice.pb.api.RollVariousRequest, hxgm30.dice.pb.api.VariousDiceRolls> getRollVariousMethod;
    if ((getRollVariousMethod = ServiceAPIGrpc.getRollVariousMethod) == null) {
      synchronized (ServiceAPIGrpc.class) {
        if ((getRollVariousMethod = ServiceAPIGrpc.getRollVariousMethod) == null) {
          ServiceAPIGrpc.getRollVariousMethod = getRollVariousMethod =
              io.grpc.MethodDescriptor.<hxgm30.dice.pb.api.RollVariousRequest, hxgm30.dice.pb.api.VariousDiceRolls>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RollVarious"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hxgm30.dice.pb.api.RollVariousRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hxgm30.dice.pb.api.VariousDiceRolls.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceAPIMethodDescriptorSupplier("RollVarious"))
              .build();
        }
      }
    }
    return getRollVariousMethod;
  }

  private static volatile io.grpc.MethodDescriptor<hxgm30.dice.pb.api.RollsRequest,
      hxgm30.dice.pb.api.MetaRoll> getRollNMetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RollNMeta",
      requestType = hxgm30.dice.pb.api.RollsRequest.class,
      responseType = hxgm30.dice.pb.api.MetaRoll.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<hxgm30.dice.pb.api.RollsRequest,
      hxgm30.dice.pb.api.MetaRoll> getRollNMetaMethod() {
    io.grpc.MethodDescriptor<hxgm30.dice.pb.api.RollsRequest, hxgm30.dice.pb.api.MetaRoll> getRollNMetaMethod;
    if ((getRollNMetaMethod = ServiceAPIGrpc.getRollNMetaMethod) == null) {
      synchronized (ServiceAPIGrpc.class) {
        if ((getRollNMetaMethod = ServiceAPIGrpc.getRollNMetaMethod) == null) {
          ServiceAPIGrpc.getRollNMetaMethod = getRollNMetaMethod =
              io.grpc.MethodDescriptor.<hxgm30.dice.pb.api.RollsRequest, hxgm30.dice.pb.api.MetaRoll>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RollNMeta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hxgm30.dice.pb.api.RollsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hxgm30.dice.pb.api.MetaRoll.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceAPIMethodDescriptorSupplier("RollNMeta"))
              .build();
        }
      }
    }
    return getRollNMetaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<hxgm30.dice.pb.api.RollVariousRequest,
      hxgm30.dice.pb.api.MetaRolls> getRollVariousMetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RollVariousMeta",
      requestType = hxgm30.dice.pb.api.RollVariousRequest.class,
      responseType = hxgm30.dice.pb.api.MetaRolls.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<hxgm30.dice.pb.api.RollVariousRequest,
      hxgm30.dice.pb.api.MetaRolls> getRollVariousMetaMethod() {
    io.grpc.MethodDescriptor<hxgm30.dice.pb.api.RollVariousRequest, hxgm30.dice.pb.api.MetaRolls> getRollVariousMetaMethod;
    if ((getRollVariousMetaMethod = ServiceAPIGrpc.getRollVariousMetaMethod) == null) {
      synchronized (ServiceAPIGrpc.class) {
        if ((getRollVariousMetaMethod = ServiceAPIGrpc.getRollVariousMetaMethod) == null) {
          ServiceAPIGrpc.getRollVariousMetaMethod = getRollVariousMetaMethod =
              io.grpc.MethodDescriptor.<hxgm30.dice.pb.api.RollVariousRequest, hxgm30.dice.pb.api.MetaRolls>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RollVariousMeta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hxgm30.dice.pb.api.RollVariousRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hxgm30.dice.pb.api.MetaRolls.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceAPIMethodDescriptorSupplier("RollVariousMeta"))
              .build();
        }
      }
    }
    return getRollVariousMetaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<hxgm30.dice.pb.api.VersionRequest,
      hxgm30.dice.pb.api.VersionReply> getVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Version",
      requestType = hxgm30.dice.pb.api.VersionRequest.class,
      responseType = hxgm30.dice.pb.api.VersionReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<hxgm30.dice.pb.api.VersionRequest,
      hxgm30.dice.pb.api.VersionReply> getVersionMethod() {
    io.grpc.MethodDescriptor<hxgm30.dice.pb.api.VersionRequest, hxgm30.dice.pb.api.VersionReply> getVersionMethod;
    if ((getVersionMethod = ServiceAPIGrpc.getVersionMethod) == null) {
      synchronized (ServiceAPIGrpc.class) {
        if ((getVersionMethod = ServiceAPIGrpc.getVersionMethod) == null) {
          ServiceAPIGrpc.getVersionMethod = getVersionMethod =
              io.grpc.MethodDescriptor.<hxgm30.dice.pb.api.VersionRequest, hxgm30.dice.pb.api.VersionReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Version"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hxgm30.dice.pb.api.VersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hxgm30.dice.pb.api.VersionReply.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceAPIMethodDescriptorSupplier("Version"))
              .build();
        }
      }
    }
    return getVersionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServiceAPIStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceAPIStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceAPIStub>() {
        @java.lang.Override
        public ServiceAPIStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceAPIStub(channel, callOptions);
        }
      };
    return ServiceAPIStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceAPIBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceAPIBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceAPIBlockingStub>() {
        @java.lang.Override
        public ServiceAPIBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceAPIBlockingStub(channel, callOptions);
        }
      };
    return ServiceAPIBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServiceAPIFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceAPIFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceAPIFutureStub>() {
        @java.lang.Override
        public ServiceAPIFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceAPIFutureStub(channel, callOptions);
        }
      };
    return ServiceAPIFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ServiceAPIImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Return "pong" for "ping"
     * </pre>
     */
    public void ping(hxgm30.dice.pb.api.PingRequest request,
        io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.PingReply> responseObserver) {
      asyncUnimplementedUnaryCall(getPingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Dice-rolling API
     * </pre>
     */
    public void roll(hxgm30.dice.pb.api.RollRequest request,
        io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.DiceRoll> responseObserver) {
      asyncUnimplementedUnaryCall(getRollMethod(), responseObserver);
    }

    /**
     */
    public void rollN(hxgm30.dice.pb.api.RollsRequest request,
        io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.DiceRolls> responseObserver) {
      asyncUnimplementedUnaryCall(getRollNMethod(), responseObserver);
    }

    /**
     */
    public void rollVarious(hxgm30.dice.pb.api.RollVariousRequest request,
        io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.VariousDiceRolls> responseObserver) {
      asyncUnimplementedUnaryCall(getRollVariousMethod(), responseObserver);
    }

    /**
     */
    public void rollNMeta(hxgm30.dice.pb.api.RollsRequest request,
        io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.MetaRoll> responseObserver) {
      asyncUnimplementedUnaryCall(getRollNMetaMethod(), responseObserver);
    }

    /**
     */
    public void rollVariousMeta(hxgm30.dice.pb.api.RollVariousRequest request,
        io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.MetaRolls> responseObserver) {
      asyncUnimplementedUnaryCall(getRollVariousMetaMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get version data
     * </pre>
     */
    public void version(hxgm30.dice.pb.api.VersionRequest request,
        io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.VersionReply> responseObserver) {
      asyncUnimplementedUnaryCall(getVersionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                hxgm30.dice.pb.api.PingRequest,
                hxgm30.dice.pb.api.PingReply>(
                  this, METHODID_PING)))
          .addMethod(
            getRollMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                hxgm30.dice.pb.api.RollRequest,
                hxgm30.dice.pb.api.DiceRoll>(
                  this, METHODID_ROLL)))
          .addMethod(
            getRollNMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                hxgm30.dice.pb.api.RollsRequest,
                hxgm30.dice.pb.api.DiceRolls>(
                  this, METHODID_ROLL_N)))
          .addMethod(
            getRollVariousMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                hxgm30.dice.pb.api.RollVariousRequest,
                hxgm30.dice.pb.api.VariousDiceRolls>(
                  this, METHODID_ROLL_VARIOUS)))
          .addMethod(
            getRollNMetaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                hxgm30.dice.pb.api.RollsRequest,
                hxgm30.dice.pb.api.MetaRoll>(
                  this, METHODID_ROLL_NMETA)))
          .addMethod(
            getRollVariousMetaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                hxgm30.dice.pb.api.RollVariousRequest,
                hxgm30.dice.pb.api.MetaRolls>(
                  this, METHODID_ROLL_VARIOUS_META)))
          .addMethod(
            getVersionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                hxgm30.dice.pb.api.VersionRequest,
                hxgm30.dice.pb.api.VersionReply>(
                  this, METHODID_VERSION)))
          .build();
    }
  }

  /**
   */
  public static final class ServiceAPIStub extends io.grpc.stub.AbstractAsyncStub<ServiceAPIStub> {
    private ServiceAPIStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceAPIStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceAPIStub(channel, callOptions);
    }

    /**
     * <pre>
     * Return "pong" for "ping"
     * </pre>
     */
    public void ping(hxgm30.dice.pb.api.PingRequest request,
        io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.PingReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Dice-rolling API
     * </pre>
     */
    public void roll(hxgm30.dice.pb.api.RollRequest request,
        io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.DiceRoll> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRollMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void rollN(hxgm30.dice.pb.api.RollsRequest request,
        io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.DiceRolls> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRollNMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void rollVarious(hxgm30.dice.pb.api.RollVariousRequest request,
        io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.VariousDiceRolls> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRollVariousMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void rollNMeta(hxgm30.dice.pb.api.RollsRequest request,
        io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.MetaRoll> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRollNMetaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void rollVariousMeta(hxgm30.dice.pb.api.RollVariousRequest request,
        io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.MetaRolls> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRollVariousMetaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get version data
     * </pre>
     */
    public void version(hxgm30.dice.pb.api.VersionRequest request,
        io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.VersionReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getVersionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServiceAPIBlockingStub extends io.grpc.stub.AbstractBlockingStub<ServiceAPIBlockingStub> {
    private ServiceAPIBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceAPIBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceAPIBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Return "pong" for "ping"
     * </pre>
     */
    public hxgm30.dice.pb.api.PingReply ping(hxgm30.dice.pb.api.PingRequest request) {
      return blockingUnaryCall(
          getChannel(), getPingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Dice-rolling API
     * </pre>
     */
    public hxgm30.dice.pb.api.DiceRoll roll(hxgm30.dice.pb.api.RollRequest request) {
      return blockingUnaryCall(
          getChannel(), getRollMethod(), getCallOptions(), request);
    }

    /**
     */
    public hxgm30.dice.pb.api.DiceRolls rollN(hxgm30.dice.pb.api.RollsRequest request) {
      return blockingUnaryCall(
          getChannel(), getRollNMethod(), getCallOptions(), request);
    }

    /**
     */
    public hxgm30.dice.pb.api.VariousDiceRolls rollVarious(hxgm30.dice.pb.api.RollVariousRequest request) {
      return blockingUnaryCall(
          getChannel(), getRollVariousMethod(), getCallOptions(), request);
    }

    /**
     */
    public hxgm30.dice.pb.api.MetaRoll rollNMeta(hxgm30.dice.pb.api.RollsRequest request) {
      return blockingUnaryCall(
          getChannel(), getRollNMetaMethod(), getCallOptions(), request);
    }

    /**
     */
    public hxgm30.dice.pb.api.MetaRolls rollVariousMeta(hxgm30.dice.pb.api.RollVariousRequest request) {
      return blockingUnaryCall(
          getChannel(), getRollVariousMetaMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get version data
     * </pre>
     */
    public hxgm30.dice.pb.api.VersionReply version(hxgm30.dice.pb.api.VersionRequest request) {
      return blockingUnaryCall(
          getChannel(), getVersionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServiceAPIFutureStub extends io.grpc.stub.AbstractFutureStub<ServiceAPIFutureStub> {
    private ServiceAPIFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceAPIFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceAPIFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Return "pong" for "ping"
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<hxgm30.dice.pb.api.PingReply> ping(
        hxgm30.dice.pb.api.PingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Dice-rolling API
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<hxgm30.dice.pb.api.DiceRoll> roll(
        hxgm30.dice.pb.api.RollRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRollMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<hxgm30.dice.pb.api.DiceRolls> rollN(
        hxgm30.dice.pb.api.RollsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRollNMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<hxgm30.dice.pb.api.VariousDiceRolls> rollVarious(
        hxgm30.dice.pb.api.RollVariousRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRollVariousMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<hxgm30.dice.pb.api.MetaRoll> rollNMeta(
        hxgm30.dice.pb.api.RollsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRollNMetaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<hxgm30.dice.pb.api.MetaRolls> rollVariousMeta(
        hxgm30.dice.pb.api.RollVariousRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRollVariousMetaMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get version data
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<hxgm30.dice.pb.api.VersionReply> version(
        hxgm30.dice.pb.api.VersionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getVersionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PING = 0;
  private static final int METHODID_ROLL = 1;
  private static final int METHODID_ROLL_N = 2;
  private static final int METHODID_ROLL_VARIOUS = 3;
  private static final int METHODID_ROLL_NMETA = 4;
  private static final int METHODID_ROLL_VARIOUS_META = 5;
  private static final int METHODID_VERSION = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServiceAPIImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceAPIImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PING:
          serviceImpl.ping((hxgm30.dice.pb.api.PingRequest) request,
              (io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.PingReply>) responseObserver);
          break;
        case METHODID_ROLL:
          serviceImpl.roll((hxgm30.dice.pb.api.RollRequest) request,
              (io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.DiceRoll>) responseObserver);
          break;
        case METHODID_ROLL_N:
          serviceImpl.rollN((hxgm30.dice.pb.api.RollsRequest) request,
              (io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.DiceRolls>) responseObserver);
          break;
        case METHODID_ROLL_VARIOUS:
          serviceImpl.rollVarious((hxgm30.dice.pb.api.RollVariousRequest) request,
              (io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.VariousDiceRolls>) responseObserver);
          break;
        case METHODID_ROLL_NMETA:
          serviceImpl.rollNMeta((hxgm30.dice.pb.api.RollsRequest) request,
              (io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.MetaRoll>) responseObserver);
          break;
        case METHODID_ROLL_VARIOUS_META:
          serviceImpl.rollVariousMeta((hxgm30.dice.pb.api.RollVariousRequest) request,
              (io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.MetaRolls>) responseObserver);
          break;
        case METHODID_VERSION:
          serviceImpl.version((hxgm30.dice.pb.api.VersionRequest) request,
              (io.grpc.stub.StreamObserver<hxgm30.dice.pb.api.VersionReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ServiceAPIBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceAPIBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return hxgm30.dice.pb.api.DiceAPIProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServiceAPI");
    }
  }

  private static final class ServiceAPIFileDescriptorSupplier
      extends ServiceAPIBaseDescriptorSupplier {
    ServiceAPIFileDescriptorSupplier() {}
  }

  private static final class ServiceAPIMethodDescriptorSupplier
      extends ServiceAPIBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServiceAPIMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ServiceAPIGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServiceAPIFileDescriptorSupplier())
              .addMethod(getPingMethod())
              .addMethod(getRollMethod())
              .addMethod(getRollNMethod())
              .addMethod(getRollVariousMethod())
              .addMethod(getRollNMetaMethod())
              .addMethod(getRollVariousMetaMethod())
              .addMethod(getVersionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
