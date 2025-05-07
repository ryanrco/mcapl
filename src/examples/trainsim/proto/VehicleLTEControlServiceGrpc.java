package trainsim.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.72.0)",
    comments = "Source: trainsim.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VehicleLTEControlServiceGrpc {

  private VehicleLTEControlServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "trainsim.VehicleLTEControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<trainsim.proto.LTENode,
      trainsim.proto.DataStatus> getInitTrainNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "initTrainNode",
      requestType = trainsim.proto.LTENode.class,
      responseType = trainsim.proto.DataStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<trainsim.proto.LTENode,
      trainsim.proto.DataStatus> getInitTrainNodeMethod() {
    io.grpc.MethodDescriptor<trainsim.proto.LTENode, trainsim.proto.DataStatus> getInitTrainNodeMethod;
    if ((getInitTrainNodeMethod = VehicleLTEControlServiceGrpc.getInitTrainNodeMethod) == null) {
      synchronized (VehicleLTEControlServiceGrpc.class) {
        if ((getInitTrainNodeMethod = VehicleLTEControlServiceGrpc.getInitTrainNodeMethod) == null) {
          VehicleLTEControlServiceGrpc.getInitTrainNodeMethod = getInitTrainNodeMethod =
              io.grpc.MethodDescriptor.<trainsim.proto.LTENode, trainsim.proto.DataStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "initTrainNode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trainsim.proto.LTENode.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trainsim.proto.DataStatus.getDefaultInstance()))
              .setSchemaDescriptor(new VehicleLTEControlServiceMethodDescriptorSupplier("initTrainNode"))
              .build();
        }
      }
    }
    return getInitTrainNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<trainsim.proto.LTENode,
      trainsim.proto.LTEData> getGetLTEDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getLTEData",
      requestType = trainsim.proto.LTENode.class,
      responseType = trainsim.proto.LTEData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<trainsim.proto.LTENode,
      trainsim.proto.LTEData> getGetLTEDataMethod() {
    io.grpc.MethodDescriptor<trainsim.proto.LTENode, trainsim.proto.LTEData> getGetLTEDataMethod;
    if ((getGetLTEDataMethod = VehicleLTEControlServiceGrpc.getGetLTEDataMethod) == null) {
      synchronized (VehicleLTEControlServiceGrpc.class) {
        if ((getGetLTEDataMethod = VehicleLTEControlServiceGrpc.getGetLTEDataMethod) == null) {
          VehicleLTEControlServiceGrpc.getGetLTEDataMethod = getGetLTEDataMethod =
              io.grpc.MethodDescriptor.<trainsim.proto.LTENode, trainsim.proto.LTEData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getLTEData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trainsim.proto.LTENode.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trainsim.proto.LTEData.getDefaultInstance()))
              .setSchemaDescriptor(new VehicleLTEControlServiceMethodDescriptorSupplier("getLTEData"))
              .build();
        }
      }
    }
    return getGetLTEDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      trainsim.proto.DataStatus> getStartSimulationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "startSimulation",
      requestType = com.google.protobuf.Empty.class,
      responseType = trainsim.proto.DataStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      trainsim.proto.DataStatus> getStartSimulationMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, trainsim.proto.DataStatus> getStartSimulationMethod;
    if ((getStartSimulationMethod = VehicleLTEControlServiceGrpc.getStartSimulationMethod) == null) {
      synchronized (VehicleLTEControlServiceGrpc.class) {
        if ((getStartSimulationMethod = VehicleLTEControlServiceGrpc.getStartSimulationMethod) == null) {
          VehicleLTEControlServiceGrpc.getStartSimulationMethod = getStartSimulationMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, trainsim.proto.DataStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "startSimulation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trainsim.proto.DataStatus.getDefaultInstance()))
              .setSchemaDescriptor(new VehicleLTEControlServiceMethodDescriptorSupplier("startSimulation"))
              .build();
        }
      }
    }
    return getStartSimulationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VehicleLTEControlServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VehicleLTEControlServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VehicleLTEControlServiceStub>() {
        @java.lang.Override
        public VehicleLTEControlServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VehicleLTEControlServiceStub(channel, callOptions);
        }
      };
    return VehicleLTEControlServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static VehicleLTEControlServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VehicleLTEControlServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VehicleLTEControlServiceBlockingV2Stub>() {
        @java.lang.Override
        public VehicleLTEControlServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VehicleLTEControlServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return VehicleLTEControlServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VehicleLTEControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VehicleLTEControlServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VehicleLTEControlServiceBlockingStub>() {
        @java.lang.Override
        public VehicleLTEControlServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VehicleLTEControlServiceBlockingStub(channel, callOptions);
        }
      };
    return VehicleLTEControlServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VehicleLTEControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VehicleLTEControlServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VehicleLTEControlServiceFutureStub>() {
        @java.lang.Override
        public VehicleLTEControlServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VehicleLTEControlServiceFutureStub(channel, callOptions);
        }
      };
    return VehicleLTEControlServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     *Used to initialise a Train from MCAPL as a node in NS3
     * </pre>
     */
    default void initTrainNode(trainsim.proto.LTENode request,
        io.grpc.stub.StreamObserver<trainsim.proto.DataStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInitTrainNodeMethod(), responseObserver);
    }

    /**
     * <pre>
     *Gets the current LTE data associated with a Train
     * </pre>
     */
    default void getLTEData(trainsim.proto.LTENode request,
        io.grpc.stub.StreamObserver<trainsim.proto.LTEData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLTEDataMethod(), responseObserver);
    }

    /**
     * <pre>
     *Used by MCAPL to declare the simulation should start
     * </pre>
     */
    default void startSimulation(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<trainsim.proto.DataStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartSimulationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service VehicleLTEControlService.
   */
  public static abstract class VehicleLTEControlServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return VehicleLTEControlServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service VehicleLTEControlService.
   */
  public static final class VehicleLTEControlServiceStub
      extends io.grpc.stub.AbstractAsyncStub<VehicleLTEControlServiceStub> {
    private VehicleLTEControlServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VehicleLTEControlServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VehicleLTEControlServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Used to initialise a Train from MCAPL as a node in NS3
     * </pre>
     */
    public void initTrainNode(trainsim.proto.LTENode request,
        io.grpc.stub.StreamObserver<trainsim.proto.DataStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInitTrainNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Gets the current LTE data associated with a Train
     * </pre>
     */
    public void getLTEData(trainsim.proto.LTENode request,
        io.grpc.stub.StreamObserver<trainsim.proto.LTEData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLTEDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Used by MCAPL to declare the simulation should start
     * </pre>
     */
    public void startSimulation(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<trainsim.proto.DataStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartSimulationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service VehicleLTEControlService.
   */
  public static final class VehicleLTEControlServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<VehicleLTEControlServiceBlockingV2Stub> {
    private VehicleLTEControlServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VehicleLTEControlServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VehicleLTEControlServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     *Used to initialise a Train from MCAPL as a node in NS3
     * </pre>
     */
    public trainsim.proto.DataStatus initTrainNode(trainsim.proto.LTENode request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitTrainNodeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Gets the current LTE data associated with a Train
     * </pre>
     */
    public trainsim.proto.LTEData getLTEData(trainsim.proto.LTENode request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLTEDataMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Used by MCAPL to declare the simulation should start
     * </pre>
     */
    public trainsim.proto.DataStatus startSimulation(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartSimulationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service VehicleLTEControlService.
   */
  public static final class VehicleLTEControlServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<VehicleLTEControlServiceBlockingStub> {
    private VehicleLTEControlServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VehicleLTEControlServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VehicleLTEControlServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Used to initialise a Train from MCAPL as a node in NS3
     * </pre>
     */
    public trainsim.proto.DataStatus initTrainNode(trainsim.proto.LTENode request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitTrainNodeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Gets the current LTE data associated with a Train
     * </pre>
     */
    public trainsim.proto.LTEData getLTEData(trainsim.proto.LTENode request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLTEDataMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Used by MCAPL to declare the simulation should start
     * </pre>
     */
    public trainsim.proto.DataStatus startSimulation(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartSimulationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service VehicleLTEControlService.
   */
  public static final class VehicleLTEControlServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<VehicleLTEControlServiceFutureStub> {
    private VehicleLTEControlServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VehicleLTEControlServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VehicleLTEControlServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Used to initialise a Train from MCAPL as a node in NS3
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<trainsim.proto.DataStatus> initTrainNode(
        trainsim.proto.LTENode request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInitTrainNodeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Gets the current LTE data associated with a Train
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<trainsim.proto.LTEData> getLTEData(
        trainsim.proto.LTENode request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLTEDataMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Used by MCAPL to declare the simulation should start
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<trainsim.proto.DataStatus> startSimulation(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartSimulationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INIT_TRAIN_NODE = 0;
  private static final int METHODID_GET_LTEDATA = 1;
  private static final int METHODID_START_SIMULATION = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INIT_TRAIN_NODE:
          serviceImpl.initTrainNode((trainsim.proto.LTENode) request,
              (io.grpc.stub.StreamObserver<trainsim.proto.DataStatus>) responseObserver);
          break;
        case METHODID_GET_LTEDATA:
          serviceImpl.getLTEData((trainsim.proto.LTENode) request,
              (io.grpc.stub.StreamObserver<trainsim.proto.LTEData>) responseObserver);
          break;
        case METHODID_START_SIMULATION:
          serviceImpl.startSimulation((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<trainsim.proto.DataStatus>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getInitTrainNodeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              trainsim.proto.LTENode,
              trainsim.proto.DataStatus>(
                service, METHODID_INIT_TRAIN_NODE)))
        .addMethod(
          getGetLTEDataMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              trainsim.proto.LTENode,
              trainsim.proto.LTEData>(
                service, METHODID_GET_LTEDATA)))
        .addMethod(
          getStartSimulationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              trainsim.proto.DataStatus>(
                service, METHODID_START_SIMULATION)))
        .build();
  }

  private static abstract class VehicleLTEControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VehicleLTEControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return trainsim.proto.TrainSimProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VehicleLTEControlService");
    }
  }

  private static final class VehicleLTEControlServiceFileDescriptorSupplier
      extends VehicleLTEControlServiceBaseDescriptorSupplier {
    VehicleLTEControlServiceFileDescriptorSupplier() {}
  }

  private static final class VehicleLTEControlServiceMethodDescriptorSupplier
      extends VehicleLTEControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    VehicleLTEControlServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (VehicleLTEControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VehicleLTEControlServiceFileDescriptorSupplier())
              .addMethod(getInitTrainNodeMethod())
              .addMethod(getGetLTEDataMethod())
              .addMethod(getStartSimulationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
