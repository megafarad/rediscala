package redis.api.sets

import redis.*
import redis.RediscalaCompat.util.ByteString

case class Srem[K, V](key: K, members: Seq[V])(implicit redisKey: ByteStringSerializer[K], convert: ByteStringSerializer[V])
    extends SimpleClusterKey[K]
    with RedisCommandIntegerLong {
  def isMasterOnly = true
  val encodedRequest: ByteString = encode("SREM", keyAsString +: members.map(v => convert.serialize(v)))
}