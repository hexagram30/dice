// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dice.proto

package hxgm30.dice.pb.api;

/**
 * <pre>
 * VersionReply ...
 * </pre>
 *
 * Protobuf type {@code api.VersionReply}
 */
public  final class VersionReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:api.VersionReply)
    VersionReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use VersionReply.newBuilder() to construct.
  private VersionReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VersionReply() {
    version_ = "";
    buildDate_ = "";
    gitCommit_ = "";
    gitBranch_ = "";
    gitSummary_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new VersionReply();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private VersionReply(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            version_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            buildDate_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            gitCommit_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            gitBranch_ = s;
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            gitSummary_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return hxgm30.dice.pb.api.DiceAPIProto.internal_static_api_VersionReply_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return hxgm30.dice.pb.api.DiceAPIProto.internal_static_api_VersionReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            hxgm30.dice.pb.api.VersionReply.class, hxgm30.dice.pb.api.VersionReply.Builder.class);
  }

  public static final int VERSION_FIELD_NUMBER = 1;
  private volatile java.lang.Object version_;
  /**
   * <code>string version = 1;</code>
   * @return The version.
   */
  public java.lang.String getVersion() {
    java.lang.Object ref = version_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      version_ = s;
      return s;
    }
  }
  /**
   * <code>string version = 1;</code>
   * @return The bytes for version.
   */
  public com.google.protobuf.ByteString
      getVersionBytes() {
    java.lang.Object ref = version_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      version_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int BUILDDATE_FIELD_NUMBER = 2;
  private volatile java.lang.Object buildDate_;
  /**
   * <code>string buildDate = 2;</code>
   * @return The buildDate.
   */
  public java.lang.String getBuildDate() {
    java.lang.Object ref = buildDate_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      buildDate_ = s;
      return s;
    }
  }
  /**
   * <code>string buildDate = 2;</code>
   * @return The bytes for buildDate.
   */
  public com.google.protobuf.ByteString
      getBuildDateBytes() {
    java.lang.Object ref = buildDate_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      buildDate_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int GITCOMMIT_FIELD_NUMBER = 3;
  private volatile java.lang.Object gitCommit_;
  /**
   * <code>string gitCommit = 3;</code>
   * @return The gitCommit.
   */
  public java.lang.String getGitCommit() {
    java.lang.Object ref = gitCommit_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      gitCommit_ = s;
      return s;
    }
  }
  /**
   * <code>string gitCommit = 3;</code>
   * @return The bytes for gitCommit.
   */
  public com.google.protobuf.ByteString
      getGitCommitBytes() {
    java.lang.Object ref = gitCommit_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      gitCommit_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int GITBRANCH_FIELD_NUMBER = 4;
  private volatile java.lang.Object gitBranch_;
  /**
   * <code>string gitBranch = 4;</code>
   * @return The gitBranch.
   */
  public java.lang.String getGitBranch() {
    java.lang.Object ref = gitBranch_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      gitBranch_ = s;
      return s;
    }
  }
  /**
   * <code>string gitBranch = 4;</code>
   * @return The bytes for gitBranch.
   */
  public com.google.protobuf.ByteString
      getGitBranchBytes() {
    java.lang.Object ref = gitBranch_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      gitBranch_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int GITSUMMARY_FIELD_NUMBER = 5;
  private volatile java.lang.Object gitSummary_;
  /**
   * <code>string gitSummary = 5;</code>
   * @return The gitSummary.
   */
  public java.lang.String getGitSummary() {
    java.lang.Object ref = gitSummary_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      gitSummary_ = s;
      return s;
    }
  }
  /**
   * <code>string gitSummary = 5;</code>
   * @return The bytes for gitSummary.
   */
  public com.google.protobuf.ByteString
      getGitSummaryBytes() {
    java.lang.Object ref = gitSummary_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      gitSummary_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getVersionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, version_);
    }
    if (!getBuildDateBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, buildDate_);
    }
    if (!getGitCommitBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, gitCommit_);
    }
    if (!getGitBranchBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, gitBranch_);
    }
    if (!getGitSummaryBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, gitSummary_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getVersionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, version_);
    }
    if (!getBuildDateBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, buildDate_);
    }
    if (!getGitCommitBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, gitCommit_);
    }
    if (!getGitBranchBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, gitBranch_);
    }
    if (!getGitSummaryBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, gitSummary_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof hxgm30.dice.pb.api.VersionReply)) {
      return super.equals(obj);
    }
    hxgm30.dice.pb.api.VersionReply other = (hxgm30.dice.pb.api.VersionReply) obj;

    if (!getVersion()
        .equals(other.getVersion())) return false;
    if (!getBuildDate()
        .equals(other.getBuildDate())) return false;
    if (!getGitCommit()
        .equals(other.getGitCommit())) return false;
    if (!getGitBranch()
        .equals(other.getGitBranch())) return false;
    if (!getGitSummary()
        .equals(other.getGitSummary())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + VERSION_FIELD_NUMBER;
    hash = (53 * hash) + getVersion().hashCode();
    hash = (37 * hash) + BUILDDATE_FIELD_NUMBER;
    hash = (53 * hash) + getBuildDate().hashCode();
    hash = (37 * hash) + GITCOMMIT_FIELD_NUMBER;
    hash = (53 * hash) + getGitCommit().hashCode();
    hash = (37 * hash) + GITBRANCH_FIELD_NUMBER;
    hash = (53 * hash) + getGitBranch().hashCode();
    hash = (37 * hash) + GITSUMMARY_FIELD_NUMBER;
    hash = (53 * hash) + getGitSummary().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static hxgm30.dice.pb.api.VersionReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static hxgm30.dice.pb.api.VersionReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static hxgm30.dice.pb.api.VersionReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static hxgm30.dice.pb.api.VersionReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static hxgm30.dice.pb.api.VersionReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static hxgm30.dice.pb.api.VersionReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static hxgm30.dice.pb.api.VersionReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static hxgm30.dice.pb.api.VersionReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static hxgm30.dice.pb.api.VersionReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static hxgm30.dice.pb.api.VersionReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static hxgm30.dice.pb.api.VersionReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static hxgm30.dice.pb.api.VersionReply parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(hxgm30.dice.pb.api.VersionReply prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * VersionReply ...
   * </pre>
   *
   * Protobuf type {@code api.VersionReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:api.VersionReply)
      hxgm30.dice.pb.api.VersionReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return hxgm30.dice.pb.api.DiceAPIProto.internal_static_api_VersionReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return hxgm30.dice.pb.api.DiceAPIProto.internal_static_api_VersionReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              hxgm30.dice.pb.api.VersionReply.class, hxgm30.dice.pb.api.VersionReply.Builder.class);
    }

    // Construct using hxgm30.dice.pb.api.VersionReply.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      version_ = "";

      buildDate_ = "";

      gitCommit_ = "";

      gitBranch_ = "";

      gitSummary_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return hxgm30.dice.pb.api.DiceAPIProto.internal_static_api_VersionReply_descriptor;
    }

    @java.lang.Override
    public hxgm30.dice.pb.api.VersionReply getDefaultInstanceForType() {
      return hxgm30.dice.pb.api.VersionReply.getDefaultInstance();
    }

    @java.lang.Override
    public hxgm30.dice.pb.api.VersionReply build() {
      hxgm30.dice.pb.api.VersionReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public hxgm30.dice.pb.api.VersionReply buildPartial() {
      hxgm30.dice.pb.api.VersionReply result = new hxgm30.dice.pb.api.VersionReply(this);
      result.version_ = version_;
      result.buildDate_ = buildDate_;
      result.gitCommit_ = gitCommit_;
      result.gitBranch_ = gitBranch_;
      result.gitSummary_ = gitSummary_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof hxgm30.dice.pb.api.VersionReply) {
        return mergeFrom((hxgm30.dice.pb.api.VersionReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(hxgm30.dice.pb.api.VersionReply other) {
      if (other == hxgm30.dice.pb.api.VersionReply.getDefaultInstance()) return this;
      if (!other.getVersion().isEmpty()) {
        version_ = other.version_;
        onChanged();
      }
      if (!other.getBuildDate().isEmpty()) {
        buildDate_ = other.buildDate_;
        onChanged();
      }
      if (!other.getGitCommit().isEmpty()) {
        gitCommit_ = other.gitCommit_;
        onChanged();
      }
      if (!other.getGitBranch().isEmpty()) {
        gitBranch_ = other.gitBranch_;
        onChanged();
      }
      if (!other.getGitSummary().isEmpty()) {
        gitSummary_ = other.gitSummary_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      hxgm30.dice.pb.api.VersionReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (hxgm30.dice.pb.api.VersionReply) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object version_ = "";
    /**
     * <code>string version = 1;</code>
     * @return The version.
     */
    public java.lang.String getVersion() {
      java.lang.Object ref = version_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        version_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string version = 1;</code>
     * @return The bytes for version.
     */
    public com.google.protobuf.ByteString
        getVersionBytes() {
      java.lang.Object ref = version_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        version_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string version = 1;</code>
     * @param value The version to set.
     * @return This builder for chaining.
     */
    public Builder setVersion(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      version_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string version = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearVersion() {
      
      version_ = getDefaultInstance().getVersion();
      onChanged();
      return this;
    }
    /**
     * <code>string version = 1;</code>
     * @param value The bytes for version to set.
     * @return This builder for chaining.
     */
    public Builder setVersionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      version_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object buildDate_ = "";
    /**
     * <code>string buildDate = 2;</code>
     * @return The buildDate.
     */
    public java.lang.String getBuildDate() {
      java.lang.Object ref = buildDate_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        buildDate_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string buildDate = 2;</code>
     * @return The bytes for buildDate.
     */
    public com.google.protobuf.ByteString
        getBuildDateBytes() {
      java.lang.Object ref = buildDate_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        buildDate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string buildDate = 2;</code>
     * @param value The buildDate to set.
     * @return This builder for chaining.
     */
    public Builder setBuildDate(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      buildDate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string buildDate = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearBuildDate() {
      
      buildDate_ = getDefaultInstance().getBuildDate();
      onChanged();
      return this;
    }
    /**
     * <code>string buildDate = 2;</code>
     * @param value The bytes for buildDate to set.
     * @return This builder for chaining.
     */
    public Builder setBuildDateBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      buildDate_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object gitCommit_ = "";
    /**
     * <code>string gitCommit = 3;</code>
     * @return The gitCommit.
     */
    public java.lang.String getGitCommit() {
      java.lang.Object ref = gitCommit_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gitCommit_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string gitCommit = 3;</code>
     * @return The bytes for gitCommit.
     */
    public com.google.protobuf.ByteString
        getGitCommitBytes() {
      java.lang.Object ref = gitCommit_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        gitCommit_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string gitCommit = 3;</code>
     * @param value The gitCommit to set.
     * @return This builder for chaining.
     */
    public Builder setGitCommit(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      gitCommit_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string gitCommit = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearGitCommit() {
      
      gitCommit_ = getDefaultInstance().getGitCommit();
      onChanged();
      return this;
    }
    /**
     * <code>string gitCommit = 3;</code>
     * @param value The bytes for gitCommit to set.
     * @return This builder for chaining.
     */
    public Builder setGitCommitBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      gitCommit_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object gitBranch_ = "";
    /**
     * <code>string gitBranch = 4;</code>
     * @return The gitBranch.
     */
    public java.lang.String getGitBranch() {
      java.lang.Object ref = gitBranch_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gitBranch_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string gitBranch = 4;</code>
     * @return The bytes for gitBranch.
     */
    public com.google.protobuf.ByteString
        getGitBranchBytes() {
      java.lang.Object ref = gitBranch_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        gitBranch_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string gitBranch = 4;</code>
     * @param value The gitBranch to set.
     * @return This builder for chaining.
     */
    public Builder setGitBranch(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      gitBranch_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string gitBranch = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearGitBranch() {
      
      gitBranch_ = getDefaultInstance().getGitBranch();
      onChanged();
      return this;
    }
    /**
     * <code>string gitBranch = 4;</code>
     * @param value The bytes for gitBranch to set.
     * @return This builder for chaining.
     */
    public Builder setGitBranchBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      gitBranch_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object gitSummary_ = "";
    /**
     * <code>string gitSummary = 5;</code>
     * @return The gitSummary.
     */
    public java.lang.String getGitSummary() {
      java.lang.Object ref = gitSummary_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gitSummary_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string gitSummary = 5;</code>
     * @return The bytes for gitSummary.
     */
    public com.google.protobuf.ByteString
        getGitSummaryBytes() {
      java.lang.Object ref = gitSummary_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        gitSummary_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string gitSummary = 5;</code>
     * @param value The gitSummary to set.
     * @return This builder for chaining.
     */
    public Builder setGitSummary(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      gitSummary_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string gitSummary = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearGitSummary() {
      
      gitSummary_ = getDefaultInstance().getGitSummary();
      onChanged();
      return this;
    }
    /**
     * <code>string gitSummary = 5;</code>
     * @param value The bytes for gitSummary to set.
     * @return This builder for chaining.
     */
    public Builder setGitSummaryBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      gitSummary_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:api.VersionReply)
  }

  // @@protoc_insertion_point(class_scope:api.VersionReply)
  private static final hxgm30.dice.pb.api.VersionReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new hxgm30.dice.pb.api.VersionReply();
  }

  public static hxgm30.dice.pb.api.VersionReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<VersionReply>
      PARSER = new com.google.protobuf.AbstractParser<VersionReply>() {
    @java.lang.Override
    public VersionReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new VersionReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<VersionReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<VersionReply> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public hxgm30.dice.pb.api.VersionReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

