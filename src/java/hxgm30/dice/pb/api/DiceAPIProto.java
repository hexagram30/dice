// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dice.proto

package hxgm30.dice.pb.api;

public final class DiceAPIProto {
  private DiceAPIProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_RollRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_RollRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_RollsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_RollsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_RollVariousRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_RollVariousRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_DiceRoll_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_DiceRoll_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_DiceRolls_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_DiceRolls_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_VariousDiceRolls_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_VariousDiceRolls_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_DiceRollStats_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_DiceRollStats_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_MetaRoll_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_MetaRoll_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_MetaRolls_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_MetaRolls_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\ndice.proto\022\003api\0326github.com/hexagram30" +
      "/protocols/src/proto/common.proto\"\037\n\013Rol" +
      "lRequest\022\020\n\010diceType\030\001 \001(\t\"3\n\014RollsReque" +
      "st\022\020\n\010diceType\030\001 \001(\t\022\021\n\trollCount\030\002 \001(\005\"" +
      "6\n\022RollVariousRequest\022 \n\005rolls\030\001 \003(\0132\021.a" +
      "pi.RollsRequest\",\n\010DiceRoll\022\020\n\010diceType\030" +
      "\001 \001(\t\022\016\n\006result\030\002 \001(\005\"+\n\tDiceRolls\022\036\n\007re" +
      "sults\030\001 \003(\0132\r.api.DiceRoll\"3\n\020VariousDic" +
      "eRolls\022\037\n\007results\030\001 \003(\0132\016.api.DiceRolls\"" +
      "H\n\rDiceRollStats\022\017\n\007average\030\001 \001(\002\022\014\n\004hig" +
      "h\030\002 \001(\005\022\013\n\003low\030\003 \001(\005\022\013\n\003sum\030\004 \001(\005\"i\n\010Met" +
      "aRoll\022\033\n\004roll\030\001 \001(\0132\r.api.DiceRoll\022\035\n\005ro" +
      "lls\030\002 \001(\0132\016.api.DiceRolls\022!\n\005stats\030\003 \001(\013" +
      "2\022.api.DiceRollStats\"+\n\tMetaRolls\022\036\n\007res" +
      "ults\030\001 \003(\0132\r.api.MetaRoll2\224\003\n\nServiceAPI" +
      "\0220\n\004Ping\022\023.common.PingRequest\032\021.common.P" +
      "ingReply\"\000\022-\n\010RollOnce\022\020.api.RollRequest" +
      "\032\r.api.DiceRoll\"\000\0223\n\014RollRepeated\022\021.api." +
      "RollsRequest\032\016.api.DiceRolls\"\000\022?\n\013RollVa" +
      "rious\022\027.api.RollVariousRequest\032\025.api.Var" +
      "iousDiceRolls\"\000\0226\n\020RollMetaRepeated\022\021.ap" +
      "i.RollsRequest\032\r.api.MetaRoll\"\000\022<\n\017RollM" +
      "etaVarious\022\027.api.RollVariousRequest\032\016.ap" +
      "i.MetaRolls\"\000\0229\n\007Version\022\026.common.Versio" +
      "nRequest\032\024.common.VersionReply\"\000B$\n\022hxgm" +
      "30.dice.pb.apiB\014DiceAPIProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          hxgm30.proto.buf.common.CommonProto.getDescriptor(),
        });
    internal_static_api_RollRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_api_RollRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_RollRequest_descriptor,
        new java.lang.String[] { "DiceType", });
    internal_static_api_RollsRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_api_RollsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_RollsRequest_descriptor,
        new java.lang.String[] { "DiceType", "RollCount", });
    internal_static_api_RollVariousRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_api_RollVariousRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_RollVariousRequest_descriptor,
        new java.lang.String[] { "Rolls", });
    internal_static_api_DiceRoll_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_api_DiceRoll_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_DiceRoll_descriptor,
        new java.lang.String[] { "DiceType", "Result", });
    internal_static_api_DiceRolls_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_api_DiceRolls_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_DiceRolls_descriptor,
        new java.lang.String[] { "Results", });
    internal_static_api_VariousDiceRolls_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_api_VariousDiceRolls_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_VariousDiceRolls_descriptor,
        new java.lang.String[] { "Results", });
    internal_static_api_DiceRollStats_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_api_DiceRollStats_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_DiceRollStats_descriptor,
        new java.lang.String[] { "Average", "High", "Low", "Sum", });
    internal_static_api_MetaRoll_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_api_MetaRoll_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_MetaRoll_descriptor,
        new java.lang.String[] { "Roll", "Rolls", "Stats", });
    internal_static_api_MetaRolls_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_api_MetaRolls_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_MetaRolls_descriptor,
        new java.lang.String[] { "Results", });
    hxgm30.proto.buf.common.CommonProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
