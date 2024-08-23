package redis.api.keys

import redis.*
import redis.RediscalaCompat.util.ByteString

case class Type[K](key: K)(implicit redisKey: ByteStringSerializer[K]) extends SimpleClusterKey[K] with RedisCommandStatusString {
  def isMasterOnly = false
  val encodedRequest: ByteString = encode("TYPE", Seq(keyAsString))
}