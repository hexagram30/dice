// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dice.proto

package hxgm30.dice.pb.api;

public interface DiceRepeatedRollsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:api.DiceRepeatedRolls)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string diceType = 1;</code>
   * @return The diceType.
   */
  java.lang.String getDiceType();
  /**
   * <code>string diceType = 1;</code>
   * @return The bytes for diceType.
   */
  com.google.protobuf.ByteString
      getDiceTypeBytes();

  /**
   * <code>repeated int32 results = 2;</code>
   * @return A list containing the results.
   */
  java.util.List<java.lang.Integer> getResultsList();
  /**
   * <code>repeated int32 results = 2;</code>
   * @return The count of results.
   */
  int getResultsCount();
  /**
   * <code>repeated int32 results = 2;</code>
   * @param index The index of the element to return.
   * @return The results at the given index.
   */
  int getResults(int index);
}
