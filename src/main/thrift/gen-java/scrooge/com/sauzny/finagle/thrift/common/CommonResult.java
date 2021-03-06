/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.sauzny.finagle.thrift.common;

import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

// No additional import required for struct/union.

public class CommonResult implements TBase<CommonResult, CommonResult._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("CommonResult");

  private static final TField RESULT_STATUS_FIELD_DESC = new TField("resultStatus", TType.I32, (short)1);
  private static final TField FAIL_DESC_LIST_FIELD_DESC = new TField("failDescList", TType.LIST, (short)2);
  private static final TField RESULT_MAP_FIELD_DESC = new TField("resultMap", TType.MAP, (short)3);
  private static final TField TIMING_FIELD_DESC = new TField("timing", TType.I64, (short)4);
  private static final TField TRACE_ID_FIELD_DESC = new TField("traceId", TType.STRING, (short)5);


  public ResultStatus resultStatus;
  public List<FailDesc> failDescList;
  public Map<String,String> resultMap;
  public long timing;
  public String traceId;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    RESULT_STATUS((short)1, "resultStatus"),
    FAIL_DESC_LIST((short)2, "failDescList"),
    RESULT_MAP((short)3, "resultMap"),
    TIMING((short)4, "timing"),
    TRACE_ID((short)5, "traceId");
  
    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();
  
    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }
  
    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // RESULT_STATUS
  	return RESULT_STATUS;
        case 2: // FAIL_DESC_LIST
  	return FAIL_DESC_LIST;
        case 3: // RESULT_MAP
  	return RESULT_MAP;
        case 4: // TIMING
  	return TIMING;
        case 5: // TRACE_ID
  	return TRACE_ID;
        default:
  	return null;
      }
    }
  
    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }
  
    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }
  
    private final short _thriftId;
    private final String _fieldName;
  
    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }
  
    public short getThriftFieldId() {
      return _thriftId;
    }
  
    public String getFieldName() {
      return _fieldName;
    }
  }


  // isset id assignments
  private static final int __TIMING_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESULT_STATUS, new FieldMetaData("resultStatus", TFieldRequirementType.DEFAULT,
      new EnumMetaData(TType.ENUM, ResultStatus.class)));
    tmpMap.put(_Fields.FAIL_DESC_LIST, new FieldMetaData("failDescList", TFieldRequirementType.OPTIONAL,
      new ListMetaData(TType.LIST,
                new StructMetaData(TType.STRUCT, FailDesc.class))));
    tmpMap.put(_Fields.RESULT_MAP, new FieldMetaData("resultMap", TFieldRequirementType.OPTIONAL,
      new MapMetaData(TType.MAP,
            new FieldValueMetaData(TType.STRING),
            new FieldValueMetaData(TType.STRING))));
    tmpMap.put(_Fields.TIMING, new FieldMetaData("timing", TFieldRequirementType.OPTIONAL,
      new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.TRACE_ID, new FieldMetaData("traceId", TFieldRequirementType.OPTIONAL,
      new FieldValueMetaData(TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(CommonResult.class, metaDataMap);
  }


  public CommonResult() {
    this.resultStatus = ResultStatus.failure;
  }

  public CommonResult(
    ResultStatus resultStatus)
  {
    this();
    this.resultStatus = resultStatus;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CommonResult(CommonResult other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetResultStatus()) {
      this.resultStatus = other.resultStatus;
    }
    if (other.isSetFailDescList()) {
      List<FailDesc> __this__failDescList = new ArrayList<FailDesc>();
      for (FailDesc other_element : other.failDescList) {
        __this__failDescList.add(new FailDesc(other_element));
      }
      this.failDescList = __this__failDescList;
    }
    if (other.isSetResultMap()) {
      Map<String,String> __this__resultMap = new HashMap<String,String>();
      for (Map.Entry<String, String> other_element : other.resultMap.entrySet()) {
        String other_element_key = other_element.getKey();
        String other_element_value = other_element.getValue();
        String __this__resultMap_copy_key = other_element_key;
        String __this__resultMap_copy_value = other_element_value;
        __this__resultMap.put(__this__resultMap_copy_key, __this__resultMap_copy_value);
      }
      this.resultMap = __this__resultMap;
    }
    this.timing = other.timing;
    if (other.isSetTraceId()) {
      this.traceId = other.traceId;
    }
  }

  public CommonResult deepCopy() {
    return new CommonResult(this);
  }

  @Override
  public void clear() {
    this.resultStatus = ResultStatus.failure;
    this.failDescList = null;
    this.resultMap = null;
    setTimingIsSet(false);
    this.timing = 0;
    this.traceId = null;
  }

  public ResultStatus getResultStatus() {
    return this.resultStatus;
  }

  public CommonResult setResultStatus(ResultStatus resultStatus) {
    this.resultStatus = resultStatus;
    
    return this;
  }

  public void unsetResultStatus() {
    this.resultStatus = null;
  }

  /** Returns true if field resultStatus is set (has been asigned a value) and false otherwise */
  public boolean isSetResultStatus() {
    return this.resultStatus != null;
  }

  public void setResultStatusIsSet(boolean value) {
    if (!value) {
      this.resultStatus = null;
    }
  }

  public int getFailDescListSize() {
    return (this.failDescList == null) ? 0 : this.failDescList.size();
  }

  public java.util.Iterator<FailDesc> getFailDescListIterator() {
    return (this.failDescList == null) ? null : this.failDescList.iterator();
  }

  public void addToFailDescList(FailDesc elem) {
    if (this.failDescList == null) {
      this.failDescList = new ArrayList<FailDesc>();
    }
    this.failDescList.add(elem);
  }

  public List<FailDesc> getFailDescList() {
    return this.failDescList;
  }

  public CommonResult setFailDescList(List<FailDesc> failDescList) {
    this.failDescList = failDescList;
    
    return this;
  }

  public void unsetFailDescList() {
    this.failDescList = null;
  }

  /** Returns true if field failDescList is set (has been asigned a value) and false otherwise */
  public boolean isSetFailDescList() {
    return this.failDescList != null;
  }

  public void setFailDescListIsSet(boolean value) {
    if (!value) {
      this.failDescList = null;
    }
  }

  public int getResultMapSize() {
    return (this.resultMap == null) ? 0 : this.resultMap.size();
  }

  public void putToResultMap(String key, String val) {
    if (this.resultMap == null) {
      this.resultMap = new HashMap<String,String>();
    }
    this.resultMap.put(key, val);
  }

  public Map<String,String> getResultMap() {
    return this.resultMap;
  }

  public CommonResult setResultMap(Map<String,String> resultMap) {
    this.resultMap = resultMap;
    
    return this;
  }

  public void unsetResultMap() {
    this.resultMap = null;
  }

  /** Returns true if field resultMap is set (has been asigned a value) and false otherwise */
  public boolean isSetResultMap() {
    return this.resultMap != null;
  }

  public void setResultMapIsSet(boolean value) {
    if (!value) {
      this.resultMap = null;
    }
  }

  public long getTiming() {
    return this.timing;
  }

  public CommonResult setTiming(long timing) {
    this.timing = timing;
    setTimingIsSet(true);

    return this;
  }

  public void unsetTiming() {
  __isset_bit_vector.clear(__TIMING_ISSET_ID);
  }

  /** Returns true if field timing is set (has been asigned a value) and false otherwise */
  public boolean isSetTiming() {
    return __isset_bit_vector.get(__TIMING_ISSET_ID);
  }

  public void setTimingIsSet(boolean value) {
    __isset_bit_vector.set(__TIMING_ISSET_ID, value);
  }

  public String getTraceId() {
    return this.traceId;
  }

  public CommonResult setTraceId(String traceId) {
    this.traceId = traceId;
    
    return this;
  }

  public void unsetTraceId() {
    this.traceId = null;
  }

  /** Returns true if field traceId is set (has been asigned a value) and false otherwise */
  public boolean isSetTraceId() {
    return this.traceId != null;
  }

  public void setTraceIdIsSet(boolean value) {
    if (!value) {
      this.traceId = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RESULT_STATUS:
      if (value == null) {
        unsetResultStatus();
      } else {
        setResultStatus((ResultStatus)value);
      }
      break;
    case FAIL_DESC_LIST:
      if (value == null) {
        unsetFailDescList();
      } else {
        setFailDescList((List<FailDesc>)value);
      }
      break;
    case RESULT_MAP:
      if (value == null) {
        unsetResultMap();
      } else {
        setResultMap((Map<String,String>)value);
      }
      break;
    case TIMING:
      if (value == null) {
        unsetTiming();
      } else {
        setTiming((Long)value);
      }
      break;
    case TRACE_ID:
      if (value == null) {
        unsetTraceId();
      } else {
        setTraceId((String)value);
      }
      break;
    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESULT_STATUS:
      return getResultStatus();
    case FAIL_DESC_LIST:
      return getFailDescList();
    case RESULT_MAP:
      return getResultMap();
    case TIMING:
      return new Long(getTiming());
    case TRACE_ID:
      return getTraceId();
    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RESULT_STATUS:
      return isSetResultStatus();
    case FAIL_DESC_LIST:
      return isSetFailDescList();
    case RESULT_MAP:
      return isSetResultMap();
    case TIMING:
      return isSetTiming();
    case TRACE_ID:
      return isSetTraceId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CommonResult)
      return this.equals((CommonResult)that);
    return false;
  }

  public boolean equals(CommonResult that) {
    if (that == null)
      return false;
    boolean this_present_resultStatus = true && this.isSetResultStatus();
    boolean that_present_resultStatus = true && that.isSetResultStatus();
    if (this_present_resultStatus || that_present_resultStatus) {
      if (!(this_present_resultStatus && that_present_resultStatus))
        return false;
      if (!this.resultStatus.equals(that.resultStatus))
        return false;
    }
    boolean this_present_failDescList = true && this.isSetFailDescList();
    boolean that_present_failDescList = true && that.isSetFailDescList();
    if (this_present_failDescList || that_present_failDescList) {
      if (!(this_present_failDescList && that_present_failDescList))
        return false;
      if (!this.failDescList.equals(that.failDescList))
        return false;
    }
    boolean this_present_resultMap = true && this.isSetResultMap();
    boolean that_present_resultMap = true && that.isSetResultMap();
    if (this_present_resultMap || that_present_resultMap) {
      if (!(this_present_resultMap && that_present_resultMap))
        return false;
      if (!this.resultMap.equals(that.resultMap))
        return false;
    }
    boolean this_present_timing = true && this.isSetTiming();
    boolean that_present_timing = true && that.isSetTiming();
    if (this_present_timing || that_present_timing) {
      if (!(this_present_timing && that_present_timing))
        return false;
      if (this.timing != that.timing)
        return false;
    }
    boolean this_present_traceId = true && this.isSetTraceId();
    boolean that_present_traceId = true && that.isSetTraceId();
    if (this_present_traceId || that_present_traceId) {
      if (!(this_present_traceId && that_present_traceId))
        return false;
      if (!this.traceId.equals(that.traceId))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();
    boolean present_resultStatus = true && (isSetResultStatus());
    builder.append(present_resultStatus);
    if (present_resultStatus)
      builder.append(resultStatus.getValue());
    boolean present_failDescList = true && (isSetFailDescList());
    builder.append(present_failDescList);
    if (present_failDescList)
      builder.append(failDescList);
    boolean present_resultMap = true && (isSetResultMap());
    builder.append(present_resultMap);
    if (present_resultMap)
      builder.append(resultMap);
    boolean present_timing = true && (isSetTiming());
    builder.append(present_timing);
    if (present_timing)
      builder.append(timing);
    boolean present_traceId = true && (isSetTraceId());
    builder.append(present_traceId);
    if (present_traceId)
      builder.append(traceId);
    return builder.toHashCode();
  }

  public int compareTo(CommonResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    CommonResult typedOther = (CommonResult)other;

    lastComparison = Boolean.valueOf(isSetResultStatus()).compareTo(typedOther.isSetResultStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResultStatus()) {
      lastComparison = TBaseHelper.compareTo(this.resultStatus, typedOther.resultStatus);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFailDescList()).compareTo(typedOther.isSetFailDescList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFailDescList()) {
      lastComparison = TBaseHelper.compareTo(this.failDescList, typedOther.failDescList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetResultMap()).compareTo(typedOther.isSetResultMap());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResultMap()) {
      lastComparison = TBaseHelper.compareTo(this.resultMap, typedOther.resultMap);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTiming()).compareTo(typedOther.isSetTiming());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTiming()) {
      lastComparison = TBaseHelper.compareTo(this.timing, typedOther.timing);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTraceId()).compareTo(typedOther.isSetTraceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTraceId()) {
      lastComparison = TBaseHelper.compareTo(this.traceId, typedOther.traceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) {
        break;
      }
      switch (field.id) {
        case 1: // RESULT_STATUS
          if (field.type == TType.I32) {
            this.resultStatus = ResultStatus.findByValue(iprot.readI32());
          } else {
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // FAIL_DESC_LIST
          if (field.type == TType.LIST) {
            {
            TList _list0 = iprot.readListBegin();
            this.failDescList = new ArrayList<FailDesc>(_list0.size);
            for (int _i1 = 0; _i1 < _list0.size; ++_i1)
            {
              FailDesc _elem2;
              _elem2 = new FailDesc();
              _elem2.read(iprot);
              this.failDescList.add(_elem2);
            }
            iprot.readListEnd();
            }
          } else {
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // RESULT_MAP
          if (field.type == TType.MAP) {
            {
            TMap _map3 = iprot.readMapBegin();
            this.resultMap = new HashMap<String,String>(2*_map3.size);
            for (int _i4 = 0; _i4 < _map3.size; ++_i4)
            {
              String _key5;
              String _val6;
              _key5 = iprot.readString();
              _val6 = iprot.readString();
              this.resultMap.put(_key5, _val6);
            }
            iprot.readMapEnd();
            }
          } else {
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // TIMING
          if (field.type == TType.I64) {
            this.timing = iprot.readI64();
            setTimingIsSet(true);
          } else {
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // TRACE_ID
          if (field.type == TType.STRING) {
            this.traceId = iprot.readString();
          } else {
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();
    
    oprot.writeStructBegin(STRUCT_DESC);
    if (this.resultStatus != null) {
      oprot.writeFieldBegin(RESULT_STATUS_FIELD_DESC);
      oprot.writeI32(this.resultStatus.getValue());
      oprot.writeFieldEnd();
    }
    if (this.failDescList != null) {
      if (isSetFailDescList()) {
        oprot.writeFieldBegin(FAIL_DESC_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new TList(TType.STRUCT, this.failDescList.size()));
          for (FailDesc _iter7 : this.failDescList)
          {
            _iter7.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    if (this.resultMap != null) {
      if (isSetResultMap()) {
        oprot.writeFieldBegin(RESULT_MAP_FIELD_DESC);
        {
          oprot.writeMapBegin(new TMap(TType.STRING, TType.STRING, this.resultMap.size()));
          for (Map.Entry<String, String> _iter8 : this.resultMap.entrySet())
          {
            oprot.writeString(_iter8.getKey());
            oprot.writeString(_iter8.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    if (isSetTiming()) {
      oprot.writeFieldBegin(TIMING_FIELD_DESC);
      oprot.writeI64(this.timing);
      oprot.writeFieldEnd();
    }
    if (this.traceId != null) {
      if (isSetTraceId()) {
        oprot.writeFieldBegin(TRACE_ID_FIELD_DESC);
        oprot.writeString(this.traceId);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("CommonResult(");
    boolean first = true;
    sb.append("resultStatus:");
    if (this.resultStatus == null) {
      sb.append("null");
    } else {
      sb.append(this.resultStatus);
    }
    first = false;
    if (isSetFailDescList()) {
      if (!first) sb.append(", ");
      sb.append("failDescList:");
      if (this.failDescList == null) {
        sb.append("null");
      } else {
        sb.append(this.failDescList);
      }
      first = false;
      }
    if (isSetResultMap()) {
      if (!first) sb.append(", ");
      sb.append("resultMap:");
      if (this.resultMap == null) {
        sb.append("null");
      } else {
        sb.append(this.resultMap);
      }
      first = false;
      }
    if (isSetTiming()) {
      if (!first) sb.append(", ");
      sb.append("timing:");
      sb.append(this.timing);
      first = false;
      }
    if (isSetTraceId()) {
      if (!first) sb.append(", ");
      sb.append("traceId:");
      if (this.traceId == null) {
        sb.append("null");
      } else {
        sb.append(this.traceId);
      }
      first = false;
      }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }
}
