/*
 * Copyright 2026 mingliqiye
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ProjectName mingli-utils
 * ModuleName mingli-utils.main
 * CurrentFile FastBaseIService.kt
 * LastUpdate 2026-10-31 09:51:52
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.mybatisplus

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.toolkit.support.SFunction
import com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateChainWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.mingliqiye.utils.mybatisplus.FastBaseIService.Companion.ktQueryChainWrapper
import com.mingliqiye.utils.mybatisplus.FastBaseIService.Companion.ktQueryWrapper
import com.mingliqiye.utils.mybatisplus.FastBaseIService.Companion.ktUpdateChainWrapper
import com.mingliqiye.utils.mybatisplus.FastBaseIService.Companion.ktUpdateWrapper
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.delete
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.deleteByColumn
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.exists
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.existsByColumn
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.ktQueryChain
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.ktQueryChainWrapper
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.ktQueryWrapper
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.ktUpdateChain
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.ktUpdateChainWrapper
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.ktUpdateWrapper
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.selectCount
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.selectList
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.selectListByColumn
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.selectListByColumns
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.selectMapByColumn
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.selectOne
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.selectOneByColumn
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.selectPage
import com.mingliqiye.utils.mybatisplus.FastBaseMapper.Companion.update
import kotlin.reflect.KProperty1


/**
 * MyBatis-Plus[IService]的便捷基类，在服务层暴露与[FastBaseMapper]一致的常用查询、更新、删除方法
 * 内部统一委托给[mapper]执行，避免重复书写包装器构建代码
 * @param T 实体类型
 * @param D 基础映射器类型，必须继承自[FastBaseMapper]<T>
 */
open class FastBaseIService<T, D : FastBaseMapper<T>> : ServiceImpl<D, T>(), IService<T> {

	/**
	 * 当前服务绑定的基础映射器实例，等价于[com.baomidou.mybatisplus.extension.repository.CrudRepository.getBaseMapper]
	 * @return D 继承自[FastBaseMapper]的映射器实例
	 */
	open val mapper: D
		get() = getBaseMapper()

	/**
	 * 创建[com.baomidou.mybatisplus.core.conditions.query.QueryWrapper]实例
	 * @return QueryWrapper<T> 查询包装器实例
	 */
	open fun queryWrapper() = mapper.queryWrapper()

	/**
	 * 创建[com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper]实例
	 * @return UpdateWrapper<T> 更新包装器实例
	 */
	open fun updateWrapper() = mapper.updateWrapper()

	/**
	 * 创建[com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper]实例
	 * @return LambdaQueryWrapper<T> Lambda查询包装器实例
	 */
	open fun lambdaQueryWrapper() = mapper.lambdaQueryWrapper()

	/**
	 * 创建[com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper]实例
	 * @return LambdaUpdateWrapper<T> Lambda更新包装器实例
	 */
	open fun lambdaUpdateWrapper() = mapper.lambdaUpdateWrapper()


	/**
	 * [queryWrapper]的简写形式
	 * @return QueryWrapper<T> 查询包装器实例
	 */
	open fun qw() = queryWrapper()

	/**
	 * [updateWrapper]的简写形式
	 * @return UpdateWrapper<T> 更新包装器实例
	 */
	open fun uw() = updateWrapper()

	/**
	 * [lambdaQueryWrapper]的简写形式
	 * @return LambdaQueryWrapper<T> Lambda查询包装器实例
	 */
	open fun lqw() = lambdaQueryWrapper()

	/**
	 * [lambdaUpdateWrapper]的简写形式
	 * @return LambdaUpdateWrapper<T> Lambda更新包装器实例
	 */
	open fun luw() = lambdaUpdateWrapper()


	/**
	 * 按字符串列名等值条件查询记录列表
	 * @param R 列值类型
	 * @param column 列名（数据库字段名）
	 * @param value 列值，执行等值匹配
	 * @return List<T> 查询结果列表
	 */
	open fun <R> selectListByColumn(
		column: String,
		value: R,
	) = mapper.selectListByColumn(column, value, qw())

	/**
	 * 在给定[com.baomidou.mybatisplus.core.conditions.query.QueryWrapper]上追加字符串列名等值条件并查询记录列表
	 * @param R 列值类型
	 * @param column 列名（数据库字段名）
	 * @param value 列值，执行等值匹配
	 * @param wrapper 承载查询条件的查询包装器
	 * @return List<T> 查询结果列表
	 */
	open fun <R> selectListByColumn(
		column: String,
		value: R,
		wrapper: QueryWrapper<T>,
	) = mapper.selectListByColumn(column, value, wrapper)


	/**
	 * 按方法引用列等值条件查询记录列表
	 * @param R 列值类型
	 * @param column 实体列的方法引用
	 * @param value 列值，执行等值匹配
	 * @return List<T> 查询结果列表
	 */
	open fun <R> selectListByColumn(
		column: SFunction<T, R>,
		value: R,
	) = mapper.selectListByColumn(column, value, lqw())

	/**
	 * 在给定[com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper]上追加方法引用列等值条件并查询记录列表
	 * @param R 列值类型
	 * @param column 实体列的方法引用
	 * @param value 列值，执行等值匹配
	 * @param wrapper 承载查询条件的Lambda查询包装器
	 * @return List<T> 查询结果列表
	 */
	open fun <R> selectListByColumn(
		column: SFunction<T, R>,
		value: R,
		wrapper: LambdaQueryWrapper<T>,
	) = mapper.selectListByColumn(column, value, wrapper)

	/**
	 * 按方法引用列IN条件查询记录列表，集合为空时直接返回空列表而不执行查询
	 * @param R 列值类型
	 * @param column 实体列的方法引用
	 * @param value 列值集合，执行IN匹配
	 * @return List<T> 查询结果列表
	 */
	open fun <R> selectListByColumn(
		column: SFunction<T, R>,
		value: Collection<R>,
	) = mapper.selectListByColumn(column, value, lqw())

	/**
	 * 在给定[LambdaQueryWrapper]上追加方法引用列IN条件并查询记录列表，集合为空时直接返回空列表而不执行查询
	 * @param R 列值类型
	 * @param column 实体列的方法引用
	 * @param value 列值集合，执行IN匹配
	 * @param wrapper 承载查询条件的Lambda查询包装器
	 * @return List<T> 查询结果列表
	 */
	open fun <R> selectListByColumn(
		column: SFunction<T, R>,
		value: Collection<R>,
		wrapper: LambdaQueryWrapper<T> = lqw(),
	) = mapper.selectListByColumn(column, value, wrapper)

	/**
	 * 按字符串列名IN条件查询记录列表，集合为空时直接返回空列表而不执行查询
	 * @param R 列值类型
	 * @param column 列名（数据库字段名）
	 * @param value 列值集合，执行IN匹配
	 * @return List<T> 查询结果列表
	 */
	open fun <R> selectListByColumn(
		column: String,
		value: Collection<R>,
	) = mapper.selectListByColumn(column, value, qw())

	/**
	 * 在给定[QueryWrapper]上追加字符串列名IN条件并查询记录列表，集合为空时直接返回空列表而不执行查询
	 * @param R 列值类型
	 * @param column 列名（数据库字段名）
	 * @param value 列值集合，执行IN匹配
	 * @param wrapper 承载查询条件的查询包装器
	 * @return List<T> 查询结果列表
	 */
	open fun <R> selectListByColumn(
		column: String,
		value: Collection<R>,
		wrapper: QueryWrapper<T> = qw(),
	) = mapper.selectListByColumn(column, value, wrapper)

	/**
	 * 按多个字符串列名等值条件查询记录列表，各列条件以AND连接
	 * @param columns 列名与列值构成的二元组，逐项执行等值匹配
	 * @return List<T> 查询结果列表
	 */
	open fun selectListByColumns(
		vararg columns: FastBaseMapper.StringAnyTuple2,
	) = mapper.selectListByColumns(columns = columns)

	/**
	 * 按多个方法引用列等值条件查询记录列表，各列条件以AND连接
	 * @param columns 方法引用列与列值构成的二元组，逐项执行等值匹配
	 * @return List<T> 查询结果列表
	 */
	open fun selectListByColumns(
		vararg columns: FastBaseMapper.SFunctionAnyTuple2<T, *>,
	) = mapper.selectListByColumns(lqw(), columns = columns)

	/**
	 * 在给定[LambdaQueryWrapper]上追加多个方法引用列等值条件并查询记录列表，各列条件以AND连接
	 * @param wrapper 承载查询条件的Lambda查询包装器
	 * @param columns 方法引用列与列值构成的二元组，逐项执行等值匹配
	 * @return List<T> 查询结果列表
	 */
	open fun selectListByColumns(
		wrapper: LambdaQueryWrapper<T>,
		vararg columns: FastBaseMapper.SFunctionAnyTuple2<T, *>,
	) = mapper.selectListByColumns(wrapper = wrapper, columns = columns)

	/**
	 * 按字符串列名等值条件查询单条记录，结果数量不为1时返回null
	 * @param R 列值类型
	 * @param column 列名（数据库字段名）
	 * @param value 列值，执行等值匹配
	 * @return T? 唯一的查询结果，不存在或多于一条时返回null
	 */
	open fun <R> selectOneByColumn(
		column: String,
		value: R,
	) = mapper.selectOneByColumn(column, value, qw())

	/**
	 * 在给定[QueryWrapper]上追加字符串列名等值条件并查询单条记录，结果数量不为1时返回null
	 * @param R 列值类型
	 * @param column 列名（数据库字段名）
	 * @param value 列值，执行等值匹配
	 * @param wrapper 承载查询条件的查询包装器
	 * @return T? 唯一的查询结果，不存在或多于一条时返回null
	 */
	open fun <R> selectOneByColumn(
		column: String,
		value: R,
		wrapper: QueryWrapper<T> = qw(),
	) = mapper.selectOneByColumn(
		column, value, wrapper
	)


	/**
	 * 按方法引用列等值条件查询单条记录，结果数量不为1时返回null
	 * @param R 列值类型
	 * @param column 实体列的方法引用
	 * @param value 列值，执行等值匹配
	 * @return T? 唯一的查询结果，不存在或多于一条时返回null
	 */
	open fun <R> selectOneByColumn(
		column: SFunction<T, R>,
		value: R,
	) = selectOneByColumn(
		column, value, lqw()
	)

	/**
	 * 在给定[LambdaQueryWrapper]上追加方法引用列等值条件并查询单条记录，结果数量不为1时返回null
	 * @param R 列值类型
	 * @param column 实体列的方法引用
	 * @param value 列值，执行等值匹配
	 * @param wrapper 承载查询条件的Lambda查询包装器
	 * @return T? 唯一的查询结果，不存在或多于一条时返回null
	 */
	open fun <R> selectOneByColumn(
		column: SFunction<T, R>,
		value: R,
		wrapper: LambdaQueryWrapper<T>,
	) = mapper.selectOneByColumn(
		column, value, wrapper
	)

	/**
	 * 按字符串列名等值条件判断记录是否存在
	 * @param R 列值类型
	 * @param column 列名（数据库字段名）
	 * @param value 列值，执行等值匹配
	 * @return Boolean 存在符合条件的记录返回true，否则返回false
	 */
	open fun <R> existsByColumn(
		column: String,
		value: R,
	) = mapper.existsByColumn(column, value, qw())

	/**
	 * 在给定[QueryWrapper]上追加字符串列名等值条件并判断记录是否存在
	 * @param R 列值类型
	 * @param column 列名（数据库字段名）
	 * @param value 列值，执行等值匹配
	 * @param wrapper 承载查询条件的查询包装器
	 * @return Boolean 存在符合条件的记录返回true，否则返回false
	 */
	open fun <R> existsByColumn(
		column: String,
		value: R,
		wrapper: QueryWrapper<T> = qw(),
	) = mapper.existsByColumn(
		column, value, wrapper
	)

	/**
	 * 按方法引用列等值条件判断记录是否存在
	 * @param R 列值类型
	 * @param column 实体列的方法引用
	 * @param value 列值，执行等值匹配
	 * @return Boolean 存在符合条件的记录返回true，否则返回false
	 */
	open fun <R> existsByColumn(
		column: SFunction<T, R>,
		value: R,
	) = mapper.existsByColumn(column, value, lqw())

	/**
	 * 在给定[LambdaQueryWrapper]上追加方法引用列等值条件并判断记录是否存在
	 * @param R 列值类型
	 * @param column 实体列的方法引用
	 * @param value 列值，执行等值匹配
	 * @param wrapper 承载查询条件的Lambda查询包装器
	 * @return Boolean 存在符合条件的记录返回true，否则返回false
	 */
	open fun <R> existsByColumn(
		column: SFunction<T, R>,
		value: R,
		wrapper: LambdaQueryWrapper<T> = lqw(),
	) = mapper.existsByColumn(
		column, value, wrapper
	)

	/**
	 * 按方法引用列IN条件查询记录并构建有序映射，集合为空时直接返回空映射而不执行查询
	 * 返回的[LinkedHashMap]保持入参集合的迭代顺序，缺失的键对应的值为null
	 * @param R 列值类型
	 * @param column 实体列的方法引用
	 * @param value 列值集合，执行IN匹配
	 * @return LinkedHashMap<R, T?> 以列值为键、实体为值的有序映射
	 */
	open fun <R> selectMapByColumn(
		column: SFunction<T, R>,
		value: Collection<R>,
	) = mapper.selectMapByColumn(column, value, lqw())


	/**
	 * 在给定[LambdaQueryWrapper]上按方法引用列IN条件查询记录并构建有序映射，集合为空时直接返回空映射而不执行查询
	 * 返回的[LinkedHashMap]保持入参集合的迭代顺序，缺失的键对应的值为null
	 * @param R 列值类型
	 * @param column 实体列的方法引用
	 * @param value 列值集合，执行IN匹配
	 * @param wrapper 承载查询条件的Lambda查询包装器
	 * @return LinkedHashMap<R, T?> 以列值为键、实体为值的有序映射
	 */
	open fun <R> selectMapByColumn(
		column: SFunction<T, R>,
		value: Collection<R>,
		wrapper: LambdaQueryWrapper<T> = lqw(),
	) = mapper.selectMapByColumn(column, value, wrapper)

	/**
	 * 按字符串列名IN条件删除记录，集合为空时直接返回0而不执行删除
	 * @param R 列值类型
	 * @param column 列名（数据库字段名）
	 * @param value 列值集合，执行IN匹配
	 * @return Int 被删除的行数
	 */
	open fun <R> deleteByColumn(
		column: String,
		value: Collection<R>,
	) = mapper.deleteByColumn(column, value, qw())

	/**
	 * 在给定[QueryWrapper]上按字符串列名IN条件删除记录，集合为空时直接返回0而不执行删除
	 * 注意：MyBatis-Plus对空集合的IN条件会整体跳过，若不拦截将导致全表删除
	 * @param R 列值类型
	 * @param column 列名（数据库字段名）
	 * @param value 列值集合，执行IN匹配
	 * @param wrapper 承载查询条件的查询包装器
	 * @return Int 被删除的行数
	 */
	open fun <R> deleteByColumn(
		column: String,
		value: Collection<R>,
		wrapper: QueryWrapper<T> = qw(),
	) = mapper.deleteByColumn(column, value, wrapper)

	/**
	 * 按方法引用列IN条件删除记录，集合为空时直接返回0而不执行删除
	 * @param R 列值类型
	 * @param column 实体列的方法引用
	 * @param value 列值集合，执行IN匹配
	 * @return Int 被删除的行数
	 */
	open fun <R> deleteByColumn(
		column: SFunction<T, R>,
		value: Collection<R>,
	) = mapper.deleteByColumn(column, value, lqw())

	/**
	 * 在给定[LambdaQueryWrapper]上按方法引用列IN条件删除记录，集合为空时直接返回0而不执行删除
	 * 注意：MyBatis-Plus对空集合的IN条件会整体跳过，若不拦截将导致全表删除
	 * @param R 列值类型
	 * @param column 实体列的方法引用
	 * @param value 列值集合，执行IN匹配
	 * @param wrapper 承载查询条件的Lambda查询包装器
	 * @return Int 被删除的行数
	 */
	open fun <R> deleteByColumn(
		column: SFunction<T, R>,
		value: Collection<R>,
		wrapper: LambdaQueryWrapper<T>,
	) = mapper.deleteByColumn(column, value, wrapper)

	companion object {

		/**
		 * 为[FastBaseIService]绑定的实体类型创建[com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper]实例
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @return KtQueryWrapper<T> Kotlin查询包装器实例，使用T类作为参数
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.ktQueryWrapper(): KtQueryWrapper<T> =
			KtQueryWrapper(T::class.java)

		/**
		 * 为[FastBaseIService]绑定的实体类型创建[com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper]实例
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @return KtQueryChainWrapper<T> Kotlin查询链式包装器实例，使用T类作为参数
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.ktQueryChainWrapper(): KtQueryChainWrapper<T> =
			KtQueryChainWrapper(T::class.java)

		/**
		 * 为[FastBaseIService]绑定的实体类型创建[com.baomidou.mybatisplus.extension.kotlin.KtUpdateWrapper]实例
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @return KtUpdateWrapper<T> Kotlin更新包装器实例，使用T类作为参数
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.ktUpdateWrapper(): KtUpdateWrapper<T> =
			KtUpdateWrapper(T::class.java)

		/**
		 * 为[FastBaseIService]绑定的实体类型创建[com.baomidou.mybatisplus.extension.kotlin.KtUpdateChainWrapper]实例
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @return KtUpdateChainWrapper<T> Kotlin更新链式包装器实例，使用T类作为参数
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.ktUpdateChainWrapper(): KtUpdateChainWrapper<T> =
			KtUpdateChainWrapper(T::class.java)

		/**
		 * 创建绑定当前映射器的[KtQueryChainWrapper]实例
		 * 与[ktQueryChainWrapper]不同，该链式包装器持有映射器引用，可直接调用`list`/`one`/`page`等方法执行查询
		 * @param T 实体类型，必须继承自Any
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @return KtQueryChainWrapper<T> 可执行的Kotlin查询链式包装器实例
		 */
		fun <T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.ktQueryChain(): KtQueryChainWrapper<T> =
			this.mapper.ktQueryChain()

		/**
		 * 创建绑定当前映射器的[KtUpdateChainWrapper]实例
		 * 与[ktUpdateChainWrapper]不同，该链式包装器持有映射器引用，可直接调用`update`/`remove`等方法执行操作
		 * @param T 实体类型，必须继承自Any
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @return KtUpdateChainWrapper<T> 可执行的Kotlin更新链式包装器实例
		 */
		fun <T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.ktUpdateChain(): KtUpdateChainWrapper<T> =
			this.mapper.ktUpdateChain()

		/**
		 * [ktQueryWrapper]的简写形式
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @return KtQueryWrapper<T> Kotlin查询包装器实例，使用T类作为参数
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.kqw(): KtQueryWrapper<T> =
			this.mapper.ktQueryWrapper()

		/**
		 * [ktUpdateWrapper]的简写形式
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @return KtUpdateWrapper<T> Kotlin更新包装器实例，使用T类作为参数
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.kuw(): KtUpdateWrapper<T> =
			this.mapper.ktUpdateWrapper()

		/**
		 * [ktQueryChainWrapper]的简写形式
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @return KtQueryChainWrapper<T> Kotlin查询链式包装器实例，使用T类作为参数
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.kqcw(): KtQueryChainWrapper<T> =
			this.mapper.ktQueryChainWrapper()

		/**
		 * [ktUpdateChainWrapper]的简写形式
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @return KtUpdateChainWrapper<T> Kotlin更新链式包装器实例，使用T类作为参数
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.kucw(): KtUpdateChainWrapper<T> =
			this.mapper.ktUpdateChainWrapper()

		/**
		 * 通过Lambda构建[KtUpdateWrapper]并执行更新
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param funs 更新包装器构建函数，返回构建完成的更新包装器
		 * @return Int 受影响的行数
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.update(funs: (wrapper: KtUpdateWrapper<T>) -> KtUpdateWrapper<T>) =
			mapper.update(funs)

		/**
		 * 通过Lambda构建[KtUpdateWrapper]并携带实体执行更新
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param entity 承载待更新字段值的实体对象
		 * @param funs 更新包装器构建函数，返回构建完成的更新包装器
		 * @return Int 受影响的行数
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.update(
			entity: T,
			funs: (wrapper: KtUpdateWrapper<T>) -> KtUpdateWrapper<T>,
		) = mapper.update(entity, funs)

		/**
		 * 通过Lambda构建[KtQueryWrapper]并执行查询
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param funs 查询包装器构建函数，返回构建完成的查询包装器
		 * @return List<T> 查询结果列表
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.selectList(funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T>) =
			mapper.selectList(funs)

		/**
		 * 通过Lambda构建[KtQueryWrapper]并执行分页查询
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param page 分页参数对象
		 * @param funs 查询包装器构建函数，返回构建完成的查询包装器
		 * @return Page<T> 分页查询结果
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.selectPage(
			page: Page<T>,
			funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T> = { it },
		) = mapper.selectPage(page, funs)

		/**
		 * 通过页码与每页大小直接执行分页查询
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param current 当前页码，从1开始
		 * @param size 每页记录数
		 * @param funs 查询包装器构建函数，返回构建完成的查询包装器
		 * @return Page<T> 分页查询结果
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.selectPage(
			current: Long,
			size: Long,
			funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T> = { it },
		) = mapper.selectPage(
			current, size, funs
		)

		/**
		 * 通过Lambda构建[KtQueryWrapper]并查询单条记录
		 * 结果数量不为1时返回null，不抛出异常
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param funs 查询包装器构建函数，返回构建完成的查询包装器
		 * @return T? 唯一的查询结果，不存在或多于一条时返回null
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.selectOne(funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T>) =
			mapper.selectOne(funs)

		/**
		 * 通过Lambda构建[KtQueryWrapper]并统计记录数
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param funs 查询包装器构建函数，返回构建完成的查询包装器
		 * @return Long 符合条件的记录总数
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.selectCount(funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T>) =
			mapper.selectCount(funs)

		/**
		 * 通过Lambda构建[KtQueryWrapper]并判断记录是否存在
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param funs 查询包装器构建函数，返回构建完成的查询包装器
		 * @return Boolean 存在符合条件的记录返回true，否则返回false
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.exists(funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T>) =
			mapper.exists(funs)

		/**
		 * 通过Lambda构建[KtQueryWrapper]并执行删除
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param funs 查询包装器构建函数，返回构建完成的查询包装器
		 * @return Int 被删除的行数
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.delete(funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T>) =
			mapper.delete(
				funs
			)

		/**
		 * 按单列等值条件查询记录列表
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @param R 列值类型
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param column 实体列属性引用
		 * @param value 列值，执行等值匹配
		 * @param funs 附加查询包装器构建函数，在等值条件之前应用
		 * @return List<T> 查询结果列表
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>, R> FastBaseIService<T, MP>.selectListByColumn(
			column: KProperty1<T, R>,
			value: R,
			funs: (w: KtQueryWrapper<T>) -> KtQueryWrapper<T> = { it },
		) = mapper.selectListByColumn(
			column, value, funs
		)

		/**
		 * 按单列IN条件查询记录列表，集合为空时直接返回空列表而不执行查询
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @param R 列值类型
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param column 实体列属性引用
		 * @param value 列值集合，执行IN匹配
		 * @param funs 附加查询包装器构建函数，在IN条件之前应用
		 * @return List<T> 查询结果列表
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>, R> FastBaseIService<T, MP>.selectListByColumn(
			column: KProperty1<T, R>,
			value: Collection<R>,
			funs: (w: KtQueryWrapper<T>) -> KtQueryWrapper<T> = { it },
		) = mapper.selectListByColumn(
			column, value, funs
		)

		/**
		 * 按多列等值条件查询记录列表
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param columns 列属性引用与列值的键值对，逐项执行等值匹配
		 * @param funs 附加查询包装器构建函数，在各列等值条件之前应用
		 * @return List<T> 查询结果列表
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>> FastBaseIService<T, MP>.selectListByColumns(
			vararg columns: Pair<KProperty1<T, *>, Any?>,
			funs: (w: KtQueryWrapper<T>) -> KtQueryWrapper<T> = { it },
		) = mapper.selectListByColumns(columns = columns, funs)

		/**
		 * 按单列等值条件查询单条记录，结果数量不为1时返回null
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @param R 列值类型
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param column 实体列属性引用
		 * @param value 列值，执行等值匹配
		 * @param funs 附加查询包装器构建函数，在等值条件之前应用
		 * @return T? 唯一的查询结果，不存在或多于一条时返回null
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>, R> FastBaseIService<T, MP>.selectOneByColumn(
			column: KProperty1<T, R>,
			value: R,
			funs: (w: KtQueryWrapper<T>) -> KtQueryWrapper<T> = { it },
		) = mapper.selectOneByColumn(
			column, value, funs
		)

		/**
		 * 按单列等值条件判断记录是否存在
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @param R 列值类型
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param column 实体列属性引用
		 * @param value 列值，执行等值匹配
		 * @param funs 附加查询包装器构建函数，在等值条件之前应用
		 * @return Boolean 存在符合条件的记录返回true，否则返回false
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>, R> FastBaseIService<T, MP>.existsByColumn(
			column: KProperty1<T, R>,
			value: R,
			funs: (w: KtQueryWrapper<T>) -> KtQueryWrapper<T> = { it },
		) = mapper.existsByColumn(
			column, value, funs
		)

		/**
		 * 按单列IN条件查询记录并构建有序映射，集合为空时直接返回空映射而不执行查询
		 * 返回的[LinkedHashMap]保持入参集合的迭代顺序，缺失的键对应的值为null
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @param R 列值类型
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param column 实体列属性引用
		 * @param value 列值集合，执行IN匹配
		 * @param funs 附加查询包装器构建函数，在IN条件之前应用
		 * @return LinkedHashMap<R, T?> 以列值为键、实体为值的有序映射
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>, R> FastBaseIService<T, MP>.selectMapByColumn(
			column: KProperty1<T, R>,
			value: Collection<R>,
			funs: (w: KtQueryWrapper<T>) -> KtQueryWrapper<T> = { it },
		) = mapper.selectMapByColumn(
			column, value, funs
		)

		/**
		 * 按单列等值条件删除记录
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @param R 列值类型
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param column 实体列属性引用
		 * @param value 列值，执行等值匹配
		 * @param funs 附加查询包装器构建函数，在等值条件之前应用
		 * @return Int 被删除的行数
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>, R> FastBaseIService<T, MP>.deleteByColumn(
			column: KProperty1<T, R>,
			value: R,
			funs: (w: KtQueryWrapper<T>) -> KtQueryWrapper<T> = { it },
		) = mapper.deleteByColumn(column, value, funs)

		/**
		 * 按单列IN条件删除记录，集合为空时直接返回0而不执行删除
		 * 注意：MyBatis-Plus对空集合的IN条件会整体跳过，若不拦截将导致全表删除
		 * @param T 实体类型，必须继承自Any，通过reified获取实际类型
		 * @param MP 基础映射器类型，必须继承自[FastBaseMapper]<T>
		 * @param R 列值类型
		 * @receiver FastBaseIService<T, MP> 快速服务实例
		 * @param column 实体列属性引用
		 * @param value 列值集合，执行IN匹配
		 * @param funs 附加查询包装器构建函数，在IN条件之前应用
		 * @return Int 被删除的行数
		 */
		inline fun <reified T : Any, MP : FastBaseMapper<T>, R> FastBaseIService<T, MP>.deleteByColumn(
			column: KProperty1<T, R>,
			value: Collection<R>,
			funs: (w: KtQueryWrapper<T>) -> KtQueryWrapper<T> = { it },
		) = mapper.deleteByColumn(column, value, funs)
	}
}
